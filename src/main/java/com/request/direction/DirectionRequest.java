package com.request.direction;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.model.User;
import com.request.DefaultGeoApiContextStarter;

import java.io.IOException;

public class DirectionRequest extends DefaultGeoApiContextStarter {

    private DirectionsApiRequest request;
    private DirectionsResult results;

    public DirectionRequest(User user) {
        super(user);
        request = null;
        results = null;
    }

    private DirectionsApiRequest request() throws InterruptedException, ApiException, IOException {
        request = DirectionsApi.newRequest(geoApiContext)
                .origin(user.getAddressOrigin())
                .destination(user.getAddressDestination())
                .mode(user.getTravelMode())
                .transitMode(user.getTransitModes())
                .alternatives(true);
        results = request.await();
        return request;
    }

    public DirectionsLeg[] getDirectionLeg() throws InterruptedException, ApiException, IOException {
        request();
        return results.routes[0].legs;
    }
}
