package com.data;

import com.startup.constants.WeekdayId;
import com.model.Courses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    private static Map<WeekdayId, List<Courses>> dataRepository = new HashMap<>();

    public static Map<WeekdayId, List<Courses>> getDataRepository(){
        return dataRepository;
    }
}
