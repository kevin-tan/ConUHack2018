package com.request.dimension;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.Duration;
import com.model.User;
import com.request.DefaultGeoApiContextStarter;

import java.io.IOException;

public class DimensionMatrixRequest extends DefaultGeoApiContextStarter{

    private DistanceMatrix results;
    private DistanceMatrixApiRequest request;

    public DimensionMatrixRequest(User user){
        super(user);
        results = null;
        request = null;
    }

    public Duration[] getTripDuration() throws InterruptedException, ApiException, IOException {
        request = DistanceMatrixApi.newRequest(geoApiContext)
                .origins(user.getAddressOrigin())
                .destinations(user.getAddressDestination())
                .mode(user.getTravelMode())
                .transitModes(user.getTransitModes());

        results = request.await();

        Duration[] durations = new Duration[results.rows.length];
        for(int i =0; i<results.rows[0].elements.length; i++){
            DistanceMatrixElement duration = results.rows[0].elements[i];
            durations[i] = duration.duration;
        }
        return durations;
    }
}
