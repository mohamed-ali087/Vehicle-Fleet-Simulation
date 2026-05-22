// Truck.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

import javafx.scene.image.Image;

public class Truck extends LandVehicle {
    private static final Image IMAGE = new Image(Truck.class.getResourceAsStream("Assets/truck.png"));
    private static final double WIDTH = 60;
    private static final double LENGTH = 160;

    protected Truck(Builder builder) {
        builder.dimensions(WIDTH, LENGTH);
        super(builder);
        setImgDefault  (IMAGE);
        setImgUp       ("Assets/Truck/up.png");
        setImgDown     ("Assets/Truck/down.png");
        setImgLeft     ("Assets/Truck/left.png");
        setImgRight    ("Assets/Truck/right.png");
        setImgUpLeft   ("Assets/Truck/upLeft.png");
        setImgUpRight  ("Assets/Truck/upRight.png");
        setImgDownLeft ("Assets/Truck/downLeft.png");
        setImgDownRight("Assets/Truck/downRight.png");
        imageView.setImage(this.imgDefault);
    }

    public static class Builder extends LandVehicle.Builder {
        @Override
        public Vehicle build() {
            return new Truck(this);
        }
    }
}