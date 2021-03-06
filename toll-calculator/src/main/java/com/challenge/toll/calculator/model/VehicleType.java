package com.challenge.toll.calculator.model;

public enum VehicleType {

    CAR("Car"),
    MOTORBIKE("Motorbike"),
    TRACTOR("Tractor"),
    EMERGENCY("Emergency"),
    DIPLOMAT("Diplomat"),
    FOREIGN("Foreign"),
    MILITARY("Military");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
