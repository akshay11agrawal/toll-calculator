package com.challenge.toll.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;

public class TollFreeDateCheckerTest {

    @Test
    public void testWeekends() {
        // Weekends
        assertTrue(TollFreeDateChecker.isTollFree(toDate("2022-09-17")));

        // Non weekends
        assertFalse(TollFreeDateChecker.isTollFree(toDate("2022-09-16")));

    }

    @Test
    public void testYearMonths() {
        assertTrue(TollFreeDateChecker.isTollFree(toDate("2022-07-11")));

        // Wrong year
        assertFalse(TollFreeDateChecker.isTollFree(toDate("2011-07-01")));

        // Wrong year, different day
        assertFalse(TollFreeDateChecker.isTollFree(toDate("2011-07-15")));

    }

    private LocalDate toDate(String date) {
        return LocalDate.parse(date);
    }

}
