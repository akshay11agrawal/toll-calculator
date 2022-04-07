package com.challenge.toll.calculator;

import com.challenge.toll.calculator.model.Vehicle;
import com.google.common.base.Preconditions;

import java.time.*;
import java.util.Arrays;
import java.util.List;

public final class TollCalculator {

    private static final int DAY_MAXIMUM_TOTAL_FEE = 60;

    private TollCalculator() {}

    /**
     * Calculate the total toll fee for one day
     * @param vehicle - the vehicle
     * @param dates   - date and time of all passes on one day
     * @return - the total toll fee for that day
     */
    public static int calculate(Vehicle vehicle, LocalDateTime...dates) {
        Preconditions.checkArgument(vehicle != null, "vehicle cannot be null");
        Preconditions.checkArgument(dates != null, "dates cannot be null - at least one needs to be specified");
        Preconditions.checkArgument(isOnSameDay(dates), "dates must be for the same day");

        System.out.println("------------------------------------");
        int tollFees = calculateAll(vehicle, dates);
        System.out.println("Dates of Travel :");
        Arrays.stream(dates).distinct().forEach(date-> System.out.println(date.toLocalDate()+" : "+date.toLocalTime())) ;
        System.out.println("Tollfees charged :"+tollFees);
        return tollFees;
    }

    private static int calculateAll(Vehicle vehicle, LocalDateTime...dates) {
        LocalDateTime intervalStart = dates[0];
        final int feeFirstTrip = calculateOne(vehicle, intervalStart);

        // Always add the initial fee and iterate over remainder
        int total = feeFirstTrip;
        List<LocalDateTime> remaining = Arrays.asList(dates).subList(1, dates.length);

        for (LocalDateTime date : remaining) {
            int feeThisTrip = calculateOne(vehicle, date);
            long minutesSinceFirstTrip = Duration.between(intervalStart, date).toMinutes();

            if (minutesSinceFirstTrip > 60) {
                // Full price mode
                total = total + feeThisTrip;
            } else if (feeFirstTrip < feeThisTrip) {
                // if 1st trip was <= 1 hour ago and this trip is more expensive, add the difference
                //(multiple fees in same hour, applying the highest one)
                total = total + Math.abs(feeThisTrip - feeFirstTrip);
            }
        }
        // max can be 60
        return total > DAY_MAXIMUM_TOTAL_FEE ? DAY_MAXIMUM_TOTAL_FEE : total;
    }

    private static int calculateOne(Vehicle vehicle, LocalDateTime date) {
        if (TollFreeVehicleChecker.isTollFree(vehicle) || TollFreeDateChecker.isTollFree(date.toLocalDate())) {
            return 0;
        }
        return TimeRangeFeeCalculator.calculate(date.toLocalTime());
    }

    static boolean isOnSameDay(LocalDateTime...dates) {
        if (dates.length == 1) return true;

        LocalDate day = dates[0].toLocalDate();
        for (LocalDateTime date : dates) {
            Preconditions.checkArgument(date != null, "date cannot be null");
            if (!day.isEqual(date.toLocalDate())) return false;
        }
        return true;
    }

}
