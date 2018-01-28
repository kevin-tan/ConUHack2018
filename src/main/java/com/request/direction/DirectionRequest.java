package com.request.direction;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.model.User;
import com.request.DefaultGeoApiContextStarter;
import org.joda.time.DateTime;

import java.io.IOException;

public class DirectionRequest extends DefaultGeoApiContextStarter {

    private DirectionsApiRequest request;
    private DirectionsResult results;

    public DirectionRequest(User user) {
        super(user);
        request = null;
        results = null;
    }

    private DirectionsApiRequest request(DateTime dateTime) throws InterruptedException, ApiException, IOException {
        request = DirectionsApi.newRequest(geoApiContext)
                .origin(user.getAddressOrigin())
                .destination(user.getAddressDestination())
                .mode(user.getTravelMode())
                .transitMode(user.getTransitModes())
                .alternatives(true)
                .departureTime(dateTime);
        results = request.await();
        return request;
    }

    public DirectionsLeg[] getDirectionLeg(DateTime dateTime) throws InterruptedException, ApiException, IOException {
        request(dateTime);
        return results.routes[0].legs;
    }
}
