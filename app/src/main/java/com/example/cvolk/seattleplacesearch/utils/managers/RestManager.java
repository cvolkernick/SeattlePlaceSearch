package com.example.cvolk.seattleplacesearch.utils.managers;

import android.app.Activity;

public class RestManager {

    public static RestManager instance = null;

    private static final String FOURSQUARE_SEARCH = "https://api.foursquare.com/v2/venues/search";
    private static final String CLIENT_ID = "VNQPNTDRJQGUOVEDAIT2AOYWQK2FPJOONTBMX35MNPHGDP3R";
    private static final String CLIENT_SECRET = "SEBZ3GPDGCIC3RXZRQSSWQY3NYYNZ5DOAPAK4XLX4J2EJWBB";
    private static final String SEATTLE_LL  = "47.6062,122.3321";

    // temp hardcodes for testing
    private static final String QUERY = "coffee";
    private static final int LIMIT = 5;

    private RestManager() {}

    public static RestManager getInstance(Activity activity) {

        if (instance == null) {
            instance = new RestManager();
        }

        return instance;
    }

    // test api search call and print to logcat
    public void TestSearchCall() {


    }
}
