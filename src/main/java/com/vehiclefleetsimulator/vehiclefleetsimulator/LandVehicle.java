package com.vehiclefleetsimulator.vehiclefleetsimulator;

public class LandVehicle extends Vehicle{
    protected LandVehicle(Builder builder) {
        super(builder);
    }

    public static class Builder extends Vehicle.Builder{
        @Override
        public Vehicle build(){
            return new LandVehicle(this);
        }
    }

    @Override
    public double getVz() {
        return 0;
    }
    @Override
    public void setVz(double vz){}

    @Override
    public void setCenterZ(double z) {} // do nothing, LandVehicle is always on land.
}
