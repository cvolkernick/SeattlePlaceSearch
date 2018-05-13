package com.example.cvolk.seattleplacesearch.utils.managers;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPrefManager {

    public static SharedPrefManager instance = null;

    public static final String PREFS_NAME = "SEATTLE_PLACE_SEARCH";
    public static final String FAVORITES = "Venu_Favorite";

    private SharedPrefManager() {}

    public static SharedPrefManager getInstance() {

        if (instance == null) {
            instance = new SharedPrefManager();
        }

        return instance;
    }

    public ArrayList<String> getFavoriteVenues(Context context) {
        SharedPreferences settings;
        List<String> favorites;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if (settings.contains(FAVORITES)) {
            String jsonFavorites = settings.getString(FAVORITES, null);
            Gson gson = new Gson();
            String[] favoriteVenues = gson.fromJson(jsonFavorites, String[].class);

            favorites = Arrays.asList(favoriteVenues);
            favorites = new ArrayList<String>(favorites);
        }
        else {
            return null;
        }

        return (ArrayList<String>) favorites;
    }

    public void addFavoriteVenue(Context context, String venueId) {
        ArrayList<String> favorites = getFavoriteVenues(context);

        if (favorites == null) {
            favorites = new ArrayList<String>();
        }

        favorites.add(venueId);
        saveFavoriteVenues(context, favorites);
    }

    public void removeFavoriteVenue(Context context, String venueId) {
        ArrayList<String> favorites = getFavoriteVenues(context);

        if (favorites != null) {
            favorites.remove(venueId);
            saveFavoriteVenues(context, favorites);
        }
    }

    private void saveFavoriteVenues(Context context, List<String> favorites) {

        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES, jsonFavorites);

        editor.commit();
    }

    public boolean venueIsFavorite(Context context, String venueId) {
        ArrayList<String> favorites = getFavoriteVenues(context);

        if (favorites != null) {
            for (String item : favorites) {
                if (item.equals(venueId)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void toggleFavorite(Context context, String venueId) {
        if (venueIsFavorite(context, venueId)) {
            removeFavoriteVenue(context, venueId);
        }
        else {
            addFavoriteVenue(context, venueId);
        }
    }
}
