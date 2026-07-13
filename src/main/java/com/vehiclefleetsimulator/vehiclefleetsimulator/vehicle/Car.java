package com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;
import com.vehiclefleetsimulator.vehiclefleetsimulator.core.Trackable;
import javafx.scene.image.Image;

public class Car extends LandVehicle{
    private static final Image IMAGE = new Image(LandVehicle.class.getResourceAsStream("Assets/Car/up.png"));
    private static final double WIDTH = 50;
    private static final double LENGTH = 100;


    protected Car(Builder builder){
        builder.dimensions(WIDTH, LENGTH);
        super(builder);
        setImgDefault (IMAGE);
        setImgUp      ("Assets/Car/up.png");
        setImgDown    ("Assets/Car/down.png");
        setImgLeft    ("Assets/Car/left.png");
        setImgRight   ("Assets/Car/right.png");
        setImgUpLeft  ("Assets/Car/upLeft.png");
        setImgUpRight ("Assets/Car/upRight.png");
        setImgDownLeft("Assets/Car/downLeft.png");
        setImgDownRight("Assets/Car/downRight.png");
        imageView.setImage(this.imgDefault);
    }
    public static class Builder extends LandVehicle.Builder{
        @Override
        public Vehicle build(){
            return new Car(this);
        }
    };

    public static int getCount(){
        int c = 0;
        for(Trackable t: Trackable.observed){
            if (t instanceof Car){
                c++;
            }
        }

        return c;
    }
}
