// Helicopter.java
package com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;

import javafx.scene.image.Image;

public class Helicopter extends AirVehicle {
    private static final Image IMAGE = new Image(Helicopter.class.getResourceAsStream("Assets/helicopter.png"));
    private static final double WIDTH = 100;
    private static final double LENGTH = 140;

    protected Helicopter(Builder builder) {
        builder.dimensions(WIDTH, LENGTH);
        super(builder);
        setImgDefault  (IMAGE);
        setImgUp       ("Assets/Helicopter/Ground/up.png");
        setImgDown     ("Assets/Helicopter/Ground/down.png");
        setImgLeft     ("Assets/Helicopter/Ground/left.png");
        setImgRight    ("Assets/Helicopter/Ground/right.png");
        setImgUpLeft   ("Assets/Helicopter/Ground/upLeft.png");
        setImgUpRight  ("Assets/Helicopter/Ground/upRight.png");
        setImgDownLeft ("Assets/Helicopter/Ground/downLeft.png");
        setImgDownRight("Assets/Helicopter/Ground/downRight.png");
        imageView.setImage(this.imgDefault);
    }

    public static class Builder extends AirVehicle.Builder {
        @Override
        public Vehicle build() {
            return new Helicopter(this);
        }
    }

    @Override
    public void setFlightState(FlightState flightState){
        /*
        This method overrides the super method to change helicopter image according to it's state
        */
        if (flightState != this.flightState){ // only change if state changes, to avoid performance issues.
            switch (flightState){
                case FLYING -> {
                    setImgUp       ("Assets/Helicopter/Flying/up.png");
                    setImgDown     ("Assets/Helicopter/Flying/down.png");
                    setImgLeft     ("Assets/Helicopter/Flying/left.png");
                    setImgRight    ("Assets/Helicopter/Flying/right.png");
                    setImgUpLeft   ("Assets/Helicopter/Flying/upLeft.png");
                    setImgUpRight  ("Assets/Helicopter/Flying/upRight.png");
                    setImgDownLeft ("Assets/Helicopter/Flying/downLeft.png");
                    setImgDownRight("Assets/Helicopter/Flying/downRight.png");
                }
                case LANDING -> {
                    setImgUp       ("Assets/Helicopter/Ground/up.png");
                    setImgDown     ("Assets/Helicopter/Ground/down.png");
                    setImgLeft     ("Assets/Helicopter/Ground/left.png");
                    setImgRight    ("Assets/Helicopter/Ground/right.png");
                    setImgUpLeft   ("Assets/Helicopter/Ground/upLeft.png");
                    setImgUpRight  ("Assets/Helicopter/Ground/upRight.png");
                    setImgDownLeft ("Assets/Helicopter/Ground/downLeft.png");
                    setImgDownRight("Assets/Helicopter/Ground/downRight.png");
                }
            }

            rotate(0); // this is just used to update image.
        }
        super.setFlightState(flightState);
    }
}