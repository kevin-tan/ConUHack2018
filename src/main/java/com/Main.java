package com;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;

public class Main {

    private static final String API_KEY = "AIzaSyCjP9a5P458mMHIoxDdV_JkX7_q278PF2M";

    public static void main(String[] args) {
        GeoApiContext geoApiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        DistanceMatrix results = null;
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext)
                .origins("8806 Tardif, Montreal, QC H8R2R7")
                .destinations("1600 Amphitheatre Parkway Mountain View, CA 94043");
        try {
            results = request.await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        for(DistanceMatrixRow distanceMatrix: results.rows){
            for(DistanceMatrixElement distanceMatrixElement : distanceMatrix.elements){
                System.out.println(gson.toJson(distanceMatrixElement.duration));
            }
        }


    }
}
