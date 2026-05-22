// Motorcycle.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

import javafx.scene.image.Image;

public class Motorcycle extends LandVehicle {
    private static final Image IMAGE = new Image(Motorcycle.class.getResourceAsStream("Assets/motorcycle.png"));
    private static final double WIDTH = 30;
    private static final double LENGTH = 70;

    protected Motorcycle(Builder builder) {
        builder.dimensions(WIDTH, LENGTH);
        super(builder);
        setImgDefault  (IMAGE);
        setImgUp       ("Assets/Motorcycle/up.png");
        setImgDown     ("Assets/Motorcycle/down.png");
        setImgLeft     ("Assets/Motorcycle/left.png");
        setImgRight    ("Assets/Motorcycle/right.png");
        setImgUpLeft   ("Assets/Motorcycle/upLeft.png");
        setImgUpRight  ("Assets/Motorcycle/upRight.png");
        setImgDownLeft ("Assets/Motorcycle/downLeft.png");
        setImgDownRight("Assets/Motorcycle/downRight.png");
        imageView.setImage(this.imgDefault);
    }

    public static class Builder extends LandVehicle.Builder {
        @Override
        public Vehicle build() {
            return new Motorcycle(this);
        }
    }
}