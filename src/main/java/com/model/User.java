package com.model;

import com.google.maps.model.TravelMode;

public class User {

    private String addressOrigin, addressDestination;
    private TravelMode travelMode;

    public User(String addressOrigin, String addressDestination, TravelMode travelMode) {
        this.addressOrigin = addressOrigin;
        this.addressDestination = addressDestination;
        this.travelMode = travelMode;
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

    public String getAddressOrigin() {
        return addressOrigin;
    }

    public String getAddressDestination() {
        return addressDestination;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }
}
