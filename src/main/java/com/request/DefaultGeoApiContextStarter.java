package com.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.model.User;

import static com.request.ApiKey.API_KEY;

public abstract class DefaultGeoApiContextStarter {

    protected final GeoApiContext geoApiContext;
    protected Gson gson;
    protected User user;

    protected DefaultGeoApiContextStarter(User user) {
        this.user = user;
        geoApiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
}
