// AirVehicle.java
package com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;

public class AirVehicle extends Vehicle {

    public enum FlightState {
        LANDING,
        FLYING,
    }

    public static final double MIN_ALTITUDE = 0;
    public static final double MAX_ALTITUDE = 100;
    private final double BASE_WIDTH;
    private final double BASE_LENGTH;

    protected FlightState flightState = FlightState.FLYING;

    protected AirVehicle(Builder builder) {
        super(builder);
        this.BASE_WIDTH  = this.width;
        this.BASE_LENGTH = this.length;
        this.setVz(builder.vZ);
    }

    public static class Builder extends Vehicle.Builder {
        @Override
        public Vehicle build() {
            return new AirVehicle(this);
        }
    }

    @Override
    public void setCenterZ(double z) {
        // clamp between ground and max altitude
//        this.centerZ = Math.max(MIN_ALTITUDE, Math.min(MAX_ALTITUDE, z));
        if (z <= MAX_ALTITUDE && z >= MIN_ALTITUDE){
            this.centerZ = z;
        } else if (z > MAX_ALTITUDE){
            this.centerZ = MAX_ALTITUDE;
        } else if (z < MIN_ALTITUDE){
            this.centerZ = MIN_ALTITUDE;
        }
    }

    @Override
    public void setVz(double vz) {
        // prevent going above max or below ground
        if (centerZ >= MAX_ALTITUDE && vz > 0) vz = 0;
        if (centerZ <= MIN_ALTITUDE && vz < 0) vz = 0;
        super.setVz(vz);
    }

    public FlightState getFlightState() {
        return flightState;
    }

    @Override
    public void update() {
        super.update();

        // --- #TODO: move this logic to the Vehicle class to avoid redundancy
        // scale imageView size based on altitude: grows from base size to 2x at MAX_ALTITUDE
        double altitudeRatio = getCenterZ() / MAX_ALTITUDE; // 0 at ground, 1 at max
        double scaleFactor = (1.0 + altitudeRatio);     // 1.0 to 2.0
        imageView.setScaleX(scaleFactor);
        imageView.setScaleY(scaleFactor);

        // scale hitbox to match visual
        this.width  = BASE_WIDTH  * scaleFactor;
        this.length = BASE_LENGTH * scaleFactor;

        setVz(getVz()); // to change Vz depending on its current altitude ( handle if reaches max)

        // change flight state according to z position
        if (getCenterZ() < 25){
            setFlightState(FlightState.LANDING);
        } else if (getCenterZ() > 25) {
            setFlightState(FlightState.FLYING);
        }
        /*
            setFlight state is override in Helicopter.
            using polymorphism, Helicopter image changes if setFlightState is called in this update method.
         */
    }

    public void setFlightState(FlightState flightState) {
        this.flightState = flightState;
    }

    @Override
    public String toString() {
        return super.toString() + " vZ = " + getVz();
    }
}