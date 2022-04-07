package com.challenge.toll.calculator;

import com.challenge.toll.calculator.model.Car;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class TollCalculatorTest {


    //maximum fees
   @Test
    public void testArgumentOneDateMaxTollFees() {
        TollCalculator.calculate(
                new Car(),
            toLocalDateTime("2022-10-17T15:30:10")
        );
    }

    //minimum fees
    @Test
    public void testArgumentOneDateMinTollFees() {
        TollCalculator.calculate(
                new Car(),
                toLocalDateTime("2022-10-17T06:25:40")
        );
    }


    //multiple fees in the same hour
    @Test
    public void testArgumentDatesOnSameHourSuccess() {
        TollCalculator.calculate(
                new Car(),
                toLocalDateTime("2022-09-15T08:20:01"),
                toLocalDateTime("2022-09-15T08:40:00"),
                toLocalDateTime("2022-09-15T08:50:59")
        );
    }

   @Test
    public void testArgumentDatesOnSameDayFailure() {
        TollCalculator.calculate(
                new Car(),
                toLocalDateTime("2022-10-10T13:59:01"),
                toLocalDateTime("2022-10-11T16:00:00")
        );
        fail("This line shouldn't have been executed at all");
    }

    //max 60 only per day
    @Test
    public void testArgumentDatesOnSameDaySuccessTollFee() {
        TollCalculator.calculate(
                new Car(),
                toLocalDateTime("2022-08-17T13:59:01"),
                toLocalDateTime("2022-08-17T16:00:00"),
                toLocalDateTime("2022-08-17T17:10:00"),
                toLocalDateTime("2022-08-17T18:12:00"),
                toLocalDateTime("2022-08-17T19:12:00"),
                toLocalDateTime("2022-08-17T20:12:00")
        );
    }

    private LocalDateTime toLocalDateTime(String date) {
        return LocalDateTime.parse(date);
    }

}
