/*
    This class is unused for now.
 */
// TurningPoint.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

public final class TurningPoint implements Trackable {

    public enum Type {
        TURN,       // changes X, Y direction
        TAKE_OFF,   // sets vZ to positive value
        LAND,       // sets vZ to negative value
        HOLD_ALT    // sets vZ to 0 -> vehicle holds current altitude
    }

    public final double X;
    public final double Y;
    public final double Z;
    public final double RADIUS;
    public final Directions DIRECTION;  // used only for TURN type
    public final Type TYPE;
    public final double VZ_VALUE;       // used for TAKE_OFF and LAND types

    /* original constructor  (Turn)*/
    public TurningPoint(double X, double Y, double Z, double RADIUS, Directions direction) {
        this(X, Y, Z, RADIUS, direction, Type.TURN, 0);
    }

    /* other types constructor */
    public TurningPoint(double X, double Y, double Z, double RADIUS, Directions direction, Type type, double vZValue) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.RADIUS = RADIUS;
        this.DIRECTION = direction;
        this.TYPE = type;
        this.VZ_VALUE = vZValue;
        Trackable.observe(this);
    }

    @Override public double getCenterX()    { return X; }
    @Override public double getCenterY()    { return Y; }
    @Override public double getCenterZ()    { return Z; }
    @Override public double getSpeed()      { return 0; }
    @Override public double getAcceleration(){ return 0; }
    @Override public double getDirection()  { return 0; }
    @Override public double getVz()         { return 0; }
    @Override public double getMass()       { return 0; }
    @Override public Alignment getAllignment(){ return Alignment.NONE; }
}