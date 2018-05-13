package com.example.cvolk.seattleplacesearch.utils.managers;

public class MapsManager {

    MapsManager instance = null;

    private MapsManager() {}

    public MapsManager getInstance() {

        if (instance == null) {
            instance = new MapsManager();
        }

        return instance;
    }

    public void getStaticMap() {

    }
}
