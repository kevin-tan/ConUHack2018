package com.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;

import static com.request.ApiKey.API_KEY;

public abstract class DefaultGeoApiContextStarter {

    protected final GeoApiContext geoApiContext;
    protected Gson gson;

    protected DefaultGeoApiContextStarter() {
        geoApiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
}
