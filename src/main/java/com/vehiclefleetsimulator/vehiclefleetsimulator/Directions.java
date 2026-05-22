/*
This enum is used mainly in Turning Point
 */

package com.vehiclefleetsimulator.vehiclefleetsimulator;

public enum Directions{
    RIGHT(90.0),
    LEFT(-90.0);

    final double DEGREE;
    Directions(double degree){
        this.DEGREE = degree;
    }
}
