package com.vehiclefleetsimulator.vehiclefleetsimulator.core;

import com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle.Vehicle;

public interface Movable extends Trackable{
    double ANIMATION_PERIODIC_TIME = 16;
    double PERIODIC_TIME_FACTOR = ANIMATION_PERIODIC_TIME / 1000;
    double MAX_SPEED = 100 * PERIODIC_TIME_FACTOR;
    double COLLISION_FACTOR = 0.5;

    void moveX(double vX);
    void moveY(double vY);
    void moveZ(double vZ);

    void move(double vX, double vY);

    void turnRight();
    void turnLeft();

    void setSpeed(double speed);
    void setVz(double vz);
    void accelerate(double a);
    void setAcceleration(double a);

    double[] calculateNextPoint();
    void update();

    Trackable getLastCollide();
    boolean isControlled();

    default void handleCollision(Movable first, Trackable second){
        // handle collision

        double newV1;
        double newV2;

        if (second instanceof Movable) {
            if (second != getLastCollide()) {
                Movable secondMovable = (Movable) second;

//                if (!first.isControlled()){
//                    newV1 = COLLISION_FACTOR * first.getSpeed();
//                    newV2 = COLLISION_FACTOR * second.getSpeed();
//                } else {
                // apply collision equations
                newV1 = COLLISION_FACTOR * ((first.getMass() - secondMovable.getMass()) * first.getSpeed() + 2 * secondMovable.getMass() * secondMovable.getSpeed()) /
                        (first.getMass() + secondMovable.getMass());
                newV2 = COLLISION_FACTOR * ((secondMovable.getMass() - first.getMass()) * secondMovable.getSpeed() + 2 * first.getMass() * first.getSpeed()) /
                        (first.getMass() + secondMovable.getMass());

//                }

                first.setSpeed(newV1);
                secondMovable.setSpeed(newV2);
            }  Vehicle.collisionsCount++; // I moved this here to only count vehicle to vehicle collide( don't include turning after hitting wall)
//            } else {
////                first.accelerate(10);
////                ((Movable) second).accelerate(10);
//                first.turnRight();
//            }

        } else {
            if (!first.isControlled()){
                first.setSpeed(first.getSpeed() * COLLISION_FACTOR); // i removed the negative here to apply turning after collision better (only reduce speed)
                if (second != getLastCollide()) first.turnRight();
            } else { // if controlled collide and count collision
                first.setSpeed(-first.getSpeed() * COLLISION_FACTOR);
                Vehicle.collisionsCount++;
            }
        }
//        System.out.print("Collsiion");
//        System.out.println(first + "with\n" + second);
    // lines if(!first.isControlled) should be moved
    }

}