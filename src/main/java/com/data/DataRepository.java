package com.data;

import com.google.maps.model.TransitMode;
import com.google.maps.model.TravelMode;
import com.model.Courses;
import com.model.User;
import com.startup.constants.WeekdayId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    private static Map<WeekdayId, List<Courses>> dataRepository = new HashMap<>();

    //Should be the only user in the program at all time
    //TODO remove all inputs and put null for all, info will be retrieved from setup - 2
    private static User user = new User("8806 Tardif, Montreal, QC H8R2R7",
            "Concordia University EV Building, 1515 Saint-Catherine St W, Montreal, QC H3G 2W1"
            ,TravelMode.TRANSIT, TransitMode.BUS, TransitMode.SUBWAY);

    public static Map<WeekdayId, List<Courses>> getDataRepository() {
        return dataRepository;
    }

    public static User getUser() {
        return user;
    }

    public static int getNumberOfTimes(WeekdayId weekdayId) {
        return dataRepository.get(weekdayId).size();
    }
}
