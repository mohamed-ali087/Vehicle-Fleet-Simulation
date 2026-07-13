// Boat.java
package com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;

import javafx.scene.image.Image;

public class Boat extends WaterVehicle {
    private static final Image IMAGE = new Image(Boat.class.getResourceAsStream("Assets/boat.png"));
    private static final double WIDTH = 60;
    private static final double LENGTH = 120;

    protected Boat(Builder builder) {
        builder.dimensions(WIDTH, LENGTH);
        super(builder);
        setImgDefault  (IMAGE);
        setImgUp       ("Assets/Boat/up.png");
        setImgDown     ("Assets/Boat/down.png");
        setImgLeft     ("Assets/Boat/left.png");
        setImgRight    ("Assets/Boat/right.png");
        setImgUpLeft   ("Assets/Boat/upLeft.png");
        setImgUpRight  ("Assets/Boat/upRight.png");
        setImgDownLeft ("Assets/Boat/downLeft.png");
        setImgDownRight("Assets/Boat/downRight.png");
        imageView.setImage(this.imgDefault);
    }

    public static class Builder extends WaterVehicle.Builder {
        @Override
        public Vehicle build() {
            return new Boat(this);
        }
    }

    @Override
    public void setCenterZ(double z) {} // boats don't sink

    @Override
    public double getVz() {
        return 0;
    }

    @Override
    public void setVz(double vz) {} // boats don't go underwater
}