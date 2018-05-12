package com.example.cvolk.seattleplacesearch.utils.managers;

import android.app.Activity;
import android.util.Log;

import com.example.cvolk.seattleplacesearch.model.FourSquareResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static android.content.ContentValues.TAG;

public class RestManager {

    public static RestManager instance = null;

    private static final String API_BASE_URL = "https://api.foursquare.com/";
    private static final String FOURSQUARE_SEARCH = "v2/venues/search";
    private static final String CLIENT_ID = "VNQPNTDRJQGUOVEDAIT2AOYWQK2FPJOONTBMX35MNPHGDP3R";
    private static final String CLIENT_SECRET = "SEBZ3GPDGCIC3RXZRQSSWQY3NYYNZ5DOAPAK4XLX4J2EJWBB";
    private static final String LOCATION  = "Seattle,WA";
    private static final String V = "20180512";

    // temp hardcodes for testing
    private static final String QUERY = "coffee";
    private static final int LIMIT = 5;

    private RestManager() {}

    public static RestManager getInstance() {

        if (instance == null) {
            instance = new RestManager();
        }

        return instance;
    }

    // test api search call and print to logcat
    public void TestSearchCall() {

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ISearchFourSquare searchService = retro.create(ISearchFourSquare.class);
        Call<FourSquareResponse> call = searchService.getSearchResponse(CLIENT_ID, CLIENT_SECRET, LOCATION, QUERY, V);

        call.enqueue(new Callback<FourSquareResponse>() {
            @Override
            public void onResponse(Call<FourSquareResponse> call, Response<FourSquareResponse> response) {
                int statusCode = response.code();
                FourSquareResponse fourSquareResponse = response.body();

                Log.d(TAG, "onResponse (" + statusCode + "): " + "\n" + fourSquareResponse.toString());
            }

            @Override
            public void onFailure(Call<FourSquareResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public interface ISearchFourSquare {

        @GET(FOURSQUARE_SEARCH)
        Call<FourSquareResponse> getSearchResponse(
                @Query("client_id") String client_id,
                @Query("client_secret") String client_secret,
                @Query("near") String near,
                @Query("query") String query,
                @Query("v") String v
        );
    }
}
