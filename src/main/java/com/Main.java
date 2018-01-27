package com;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import com.windows.constants.FrameConstants;
import com.windows.template.Window;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import java.io.IOException;

public class Main {

    private static final String API_KEY = "AIzaSyCjP9a5P458mMHIoxDdV_JkX7_q278PF2M";

    public static void main(String[] args) {

    }

    private static Duration something() {
        GeoApiContext geoApiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        DistanceMatrix results = null;
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext)
                .origins("8806 Tardif, Montreal, QC H8R2R7")
                .destinations("Concordia University EV Building, 1515 Saint-Catherine St W, Montreal, QC H3G 2W1")
                .mode(TravelMode.TRANSIT);
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
        Duration x = null;
        for (DistanceMatrixRow distanceMatrix : results.rows) {
            for (DistanceMatrixElement distanceMatrixElement : distanceMatrix.elements) {
                x = distanceMatrixElement.duration;
            }
        }
        return x;
    }
}
