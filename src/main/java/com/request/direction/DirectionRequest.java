package com.request.direction;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TransitDetails;
import com.model.User;
import com.request.DefaultGeoApiContextStarter;
import com.utils.StringUtils;

import java.io.IOException;

public class DirectionRequest extends DefaultGeoApiContextStarter {

    private DirectionsApiRequest request;
    private DirectionsResult results;

    public DirectionRequest(User user) {
        super(user);
        request = null;
        results = null;
    }

    public String[] getStartDirection() throws InterruptedException, ApiException, IOException {
        request = DirectionsApi.newRequest(geoApiContext)
                .origin(user.getAddressOrigin())
                .destination(user.getAddressDestination())
                .mode(user.getTravelMode())
                .transitMode(user.getTransitModes())
                .alternatives(true);


        results = request.await();
        String[] routes = new String[results.routes.length];
        for (int i = 0; i < routes.length; i++) {
            TransitDetails transitDetails = results.routes[i].legs[0].steps[1].transitDetails;
            routes[i] = StringUtils.appendStrings(transitDetails.headsign, transitDetails.line.name,
                    results.routes[i].legs[0].duration.humanReadable);
        }
        return routes;
    }
}
