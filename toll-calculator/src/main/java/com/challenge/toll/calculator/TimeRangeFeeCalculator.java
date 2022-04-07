package com.challenge.toll.calculator;

import com.google.common.collect.Range;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

final class TimeRangeFeeCalculator {

    private static final Map<Range<LocalTime>, Integer> RANGES = new LinkedHashMap<>();
    static {

        RANGES.put(timeRange("00:00:01", "06:30"), 8);
        RANGES.put(timeRange("06:30", "07:00"), 13);
        RANGES.put(timeRange("07:00", "09:00"), 18);
        RANGES.put(timeRange("09:00", "15:30"), 9);
        RANGES.put(timeRange("15:30", "18:00"), 18);
        RANGES.put(timeRange("18:00", "23:59:59"), 11);
    }

    private static final Range<LocalTime> timeRange(String lower, String upper) {
        return Range.closedOpen(LocalTime.parse(lower), LocalTime.parse(upper));
    }

    private TimeRangeFeeCalculator() {}

    public static int calculate(LocalTime localTime) {
        for (Map.Entry<Range<LocalTime>, Integer> range : RANGES.entrySet()) {
            if (range.getKey().contains(localTime)) {
                return range.getValue();
            }
        }
        // Business rule is to return 0 if range/amount was not specified
        return 0;
    }

}
