package com.challenge.toll.calculator;

import com.challenge.toll.calculator.model.Car;
import com.challenge.toll.calculator.model.Motorbike;
import org.junit.Test;

import static com.challenge.toll.calculator.TollFreeVehicleChecker.isTollFree;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TollFreeVehicleCheckerTest {


    @Test
    public void testWeekends() {
        assertFalse(isTollFree(new Car()));
        assertTrue(isTollFree(new Motorbike()));
    }

}
