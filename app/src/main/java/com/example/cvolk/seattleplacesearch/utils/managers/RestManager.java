package com.example.cvolk.seattleplacesearch.utils.managers;

import android.os.AsyncTask;
import android.util.Log;

import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static android.content.ContentValues.TAG;

public class RestManager {

    public static RestManager instance = null;

    private static final String API_BASE_URL = "https://api.foursquare.com/";
    private static final String SEARCH_ENDPOINT = "v2/venues/search";
    private static final String CLIENT_ID = "VNQPNTDRJQGUOVEDAIT2AOYWQK2FPJOONTBMX35MNPHGDP3R";
    private static final String CLIENT_SECRET = "SEBZ3GPDGCIC3RXZRQSSWQY3NYYNZ5DOAPAK4XLX4J2EJWBB";
    private static final String LOCATION  = "Seattle,WA";
    private static final String V = "20180512";

    // temp hardcodes for testing
    private static final String QUERY = "coffee";
    private static final int LIMIT = 1;

    private RestManager() {}

    public static RestManager getInstance() {

        if (instance == null) {
            instance = new RestManager();
        }

        return instance;
    }

    // TODO: replace hardcoded query
    public FourSquareResponse makeSearchCall() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ISearchFourSquare searchService = retro.create(ISearchFourSquare.class);
        Call<FourSquareResponse> call = searchService.getSearchResponse(CLIENT_ID, CLIENT_SECRET, LOCATION, QUERY, LIMIT, V);

        FourSquareResponse response = null;
        try {
            response = new ApiTask().execute(call).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return response;
    }

    public interface ISearchFourSquare {

        @GET(SEARCH_ENDPOINT)
        Call<FourSquareResponse> getSearchResponse(
                @Query("client_id") String client_id,
                @Query("client_secret") String client_secret,
                @Query("near") String near,
                @Query("query") String query,
                @Query("limit") int limit,
                @Query("v") String v
        );
    }

    class ApiTask extends AsyncTask<Call<FourSquareResponse>, Void, FourSquareResponse> {

        @Override
        protected FourSquareResponse doInBackground(Call<FourSquareResponse>... calls) {
            try {
                return calls[0].execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
