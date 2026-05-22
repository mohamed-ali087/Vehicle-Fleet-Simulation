package com.vehiclefleetsimulator.vehiclefleetsimulator;

import java.util.ArrayList;

public interface Trackable {
    ArrayList<Trackable> observed = new ArrayList<>();
    static void observe(Trackable object){
        Trackable.observed.add(object);
    }
    double getCenterX();
    double getCenterY();
    double getCenterZ();
    double getSpeed();
    double getDirection();
    double getVz();
    double getAcceleration();
    double getMass();
    Alignment getAllignment();

    default double getNextX(){
        return getCenterX();
    };
    default double getNextY(){
        return getCenterY();
    };
}