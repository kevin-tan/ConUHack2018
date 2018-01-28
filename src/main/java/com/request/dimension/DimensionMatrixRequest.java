package com.request.dimension;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
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

    public Duration getTripDuration() throws InterruptedException, ApiException, IOException {
        request = DistanceMatrixApi.newRequest(geoApiContext)
                .origins(user.getAddressOrigin())
                .destinations(user.getAddressDestination())
                .mode(user.getTravelMode())
                .transitModes(user.getTransitModes());
        results = request.await();
        return results.rows[0].elements[0].duration;
    }
}
