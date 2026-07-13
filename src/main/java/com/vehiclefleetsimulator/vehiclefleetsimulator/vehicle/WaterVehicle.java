package com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;

public class WaterVehicle extends Vehicle {

    protected WaterVehicle(Builder builder) {
        super(builder);
    }

    public static class Builder extends Vehicle.Builder {
        @Override
        public Vehicle build() {
            return new WaterVehicle(this);
        }
    }

    @Override
    public void setCenterZ(double z) {
        this.centerZ = z;
    }
}
