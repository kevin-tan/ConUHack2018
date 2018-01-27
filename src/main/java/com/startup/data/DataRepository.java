package com.startup.data;

import com.startup.constants.WeekdayId;
import com.startup.model.Courses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    private Map<WeekdayId, List<Courses>> dataRepository = new HashMap<>();
}
