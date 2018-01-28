package com.program.window.thread;

import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.TransitDetails;
import com.model.Courses;
import com.program.window.ProgramWindow;
import com.request.direction.DirectionRequest;
import com.startup.constants.WeekdayId;
import com.utils.DateTimeUtils;
import com.utils.StringUtils;
import org.joda.time.format.DateTimeFormat;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DirectionRequestThread extends Thread {

    private final JLabel bus, departureFromHome, departure, arrival;
    private final DirectionRequest directionRequest;
    private final ProgramWindow programWindow;
    private Map<WeekdayId, List<Courses>> map;

    public DirectionRequestThread(ProgramWindow programWindow, DirectionRequest directionRequest, Map<WeekdayId, List<Courses>> map,
                                  JLabel bus, JLabel departureFromHome, JLabel departure, JLabel arrival) {
        this.bus = bus;
        this.departureFromHome = departureFromHome;
        this.departure = departure;
        this.arrival = arrival;
        this.map = map;
        this.directionRequest = directionRequest;
        this.programWindow = programWindow;
    }

    @Override
    public void run() {
        while (programWindow.isVisible()) {
            try {
                DirectionsLeg directionsLegDeparture = directionRequest
                        .getDirectionLeg(map
                                .get(DateTimeUtils.getEnum(DateTimeUtils.dateTime().getDayOfWeek()))
                                .get(0).getStartTime())[0];
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
