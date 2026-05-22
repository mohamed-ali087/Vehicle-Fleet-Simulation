package com.vehiclefleetsimulator.vehiclefleetsimulator;

import javafx.scene.image.Image;

public class Building extends Block{

    public Building(double centerX, double centerY, double width, double length, Image image) {
        super(centerX, centerY, width, length, image, 9999);
    }
    public Building(double centerX, double centerY, Image image){
        super(centerX, centerY, 200, 200, image , 9999);
    }

    @Override
    public void setCenterZ(double z) {} // do nothing

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public double getVz() {
        return 0;
    }

    @Override
    public double getAcceleration() {
        return 0;
    }
}