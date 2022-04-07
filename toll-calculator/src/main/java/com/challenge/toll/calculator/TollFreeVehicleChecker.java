package com.challenge.toll.calculator;

import com.challenge.toll.calculator.model.Vehicle;
import com.challenge.toll.calculator.model.VehicleType;
import com.google.common.collect.Sets;

import java.util.Set;

import static com.challenge.toll.calculator.model.VehicleType.*;

final class TollFreeVehicleChecker {

    private TollFreeVehicleChecker() {}

    private static final Set<VehicleType> TOLL_FREE_VEHICLES = Sets.newHashSet(
            MOTORBIKE, TRACTOR, EMERGENCY, DIPLOMAT, FOREIGN, MILITARY);

    static boolean isTollFree(Vehicle vehicle) {
        if(TOLL_FREE_VEHICLES.contains(vehicle.getType())){
            System.out.println(vehicle.getType() + " type falls under Toll Free Vehicle");
            return true;
        }
        return false;
    }

}
