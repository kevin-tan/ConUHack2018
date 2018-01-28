package com.model;

import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;

public class User {

    private String addressOrigin, addressDestination;
    private TravelMode travelMode;
    private TransitMode[] transitModes;

    public User(String addressOrigin, String addressDestination, TravelMode travelMode, TransitMode... transitModes) {
        this.addressOrigin = addressOrigin;
        this.addressDestination = addressDestination;
        this.travelMode = travelMode;
        this.transitModes = transitModes;
    }

    public void setAddressOrigin(String addressOrigin) {
        this.addressOrigin = addressOrigin;
    }

    public void setAddressDestination(String addressDestination) {
        this.addressDestination = addressDestination;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }

    public void setTransitModes(TransitMode... transitModes) {
        this.transitModes = transitModes;
    }

    public String getAddressOrigin() {
        return addressOrigin;
    }

    public String getAddressDestination() {
        return addressDestination;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public TransitMode[] getTransitModes() {
        return transitModes;
    }
}
