package com.program.window.thread;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.TransitDetails;
import com.program.window.ProgramWindow;
import com.request.direction.DirectionRequest;
import com.utils.DateTimeUtils;
import com.utils.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.swing.*;
import java.io.IOException;

public class DirectionRequestThread extends Thread {

    private final JLabel bus, departureFromHome, departure, arrival;
    private final DirectionRequest directionRequest;
    private final ProgramWindow programWindow;

    public DirectionRequestThread(ProgramWindow programWindow, DirectionRequest directionRequest,
                                  JLabel bus, JLabel departureFromHome, JLabel departure, JLabel arrival) {
        this.bus = bus;
        this.departureFromHome = departureFromHome;
        this.departure = departure;
        this.arrival = arrival;
        this.directionRequest = directionRequest;
        this.programWindow = programWindow;
    }

    @Override
    public void run() {
        while (programWindow.isVisible()) {
            try {
                DateTime dateTime = DateTimeUtils.dateTime();
                DirectionsLeg directionsLegDeparture = directionRequest
                        .getDirectionLeg(new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(),
                                dateTime.getDayOfMonth(), dateTime.getHourOfDay(), dateTime.getMinuteOfHour()))[0];
                TransitDetails transitDetails = directionsLegDeparture.steps[1].transitDetails;
                bus.setText(StringUtils
                        .appendStrings(transitDetails.headsign, transitDetails.line.name));
                departureFromHome.setText(directionsLegDeparture.departureTime.toString(DateTimeFormat.shortTime()));
                departure.setText(transitDetails.departureTime.toString(DateTimeFormat.shortTime()));
                arrival.setText(directionsLegDeparture.arrivalTime.toString(DateTimeFormat.shortTime()));
                sleep(60000);
            } catch (InterruptedException | ApiException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
