package com.challenge.toll.calculator;

import com.google.common.collect.Sets;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Set;

final class TollFreeDateChecker {

    //initializing holiday dates for 2022
    private static final Set<LocalDate> WHITELIST_FREE_DAYS = Sets.newHashSet(
            LocalDate.of(2022, 4, 15),
            LocalDate.of(2022, 4, 17),
            LocalDate.of(2022, 4, 18),
            LocalDate.of(2022, 4, 30),
            LocalDate.of(2022, 5, 1),
            LocalDate.of(2022, 5, 26),
            LocalDate.of(2022, 5, 27),
            LocalDate.of(2022, 5, 29),
            LocalDate.of(2022, 6, 5),
            LocalDate.of(2022, 6, 6),
            LocalDate.of(2022, 6, 24),
            LocalDate.of(2022, 6, 25),
            LocalDate.of(2022, 11, 5),
            LocalDate.of(2022, 11, 13),
            LocalDate.of(2022, 12, 24),
            LocalDate.of(2022, 12, 25),
            LocalDate.of(2022, 12, 26),
            LocalDate.of(2022, 12, 31)
    );

    //initializing summer holidays for 2022
    private static final Set<YearMonth> WHITELIST_FREE_YEAR_MONTHS = Sets.newHashSet(
            YearMonth.of(2022, 7));

    private TollFreeDateChecker() {
    }

    //check if the date is tollfree
    static boolean isTollFree(LocalDate date) {
        return isWeekend(date) || isWhitelistedFree(date);
    }

    //check if date falls under weekend
    private static boolean isWeekend(LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println(date.toString() + " falls under weekend, so no toll-fees :)");
            return true;
        }
        return false;
    }

    //check if the date comes under holidays
    private static boolean isWhitelistedFree(LocalDate date) {
        if (WHITELIST_FREE_DAYS.contains(date) || WHITELIST_FREE_YEAR_MONTHS.contains(YearMonth.from(date))) {
            System.out.println(date.toString() + " falls under holidays, so no toll-fees :) ");
            return true;
        }
        return false;
    }

}
