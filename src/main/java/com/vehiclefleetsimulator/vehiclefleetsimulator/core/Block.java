/*
    This should be the parent class for all drawable (rigid) objects.
 */
package com.vehiclefleetsimulator.vehiclefleetsimulator.core;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Block extends Rectangle implements Trackable{
    private double centerX;
    private double centerY;
    /*
          center x and centerY attributes are private,
            use setters to have effect on both Rectangle and ImageView X and Y properties.
     */
    protected double centerZ;
    protected double width; // in X-axis
    protected double length; // in Y-axis
    protected double direction;
    /*protected*/ public final ImageView imageView = new ImageView();
    protected double mass;
    protected Alignment allignment;

    public Block(double centerX, double centerY, double width, double length, Image image, double mass){
        super(centerX - width/2.0, centerY - length/2.0, width, length);
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = 0;
        this.width = width;
        this.length = length;
        this.direction = 0;
        this.setRotate(direction); // #TODO: Replace with rotate

        this.setX(centerX - width/2.0);
        this.setY(centerY - length/2.0);
        this.setWidth(width);
        this.setHeight(length);

        this.mass = mass;

        imageView.setImage(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(length);
        imageView.setX(this.getX());
        imageView.setY(this.getY());

        this.allignment = Alignment.VERTICAL;

        this.setFill(Color.TRANSPARENT);

        Trackable.observed.add(this);
    }

    // Setters & Getters

    @Override
    public double getCenterX() {
        return centerX;
    }

    @Override
    public double getCenterY() {
        return centerY;
    }

    @Override
    public double getCenterZ() {
        return centerZ;
    }

    public void setCenterX(double x){
        /*
            1- Change the rectangle X position
            2- Change ImageView X position
            3- Change centerX
         */

        // 1
        this.setX(x - width/2.0);
        // 2
        imageView.setX(this.getX());
        // 3
        this.centerX = x;
    }
    public void setCenterY(double y){
        /*
            1- Change the rectangle Y position
            2- Change ImageView Y position
            3- Change centerY
         */

        // 1
        this.setY(y - length/2.0);
        // 2
        imageView.setY(this.getY());
        // 3
        this.centerY = y;

    }
    public void setCenter(double x, double y){
        setCenterX(x); setCenterY(y);
    }

    public abstract void setCenterZ(double z); /*
        setting Z position logic vary between LandVehicle, AirVehicle and WaterVehcile.
    */



    @Override
    public double getDirection() {
        return direction % 360;
    }

    @Override
    public Alignment getAllignment() {
        return allignment;
    }

    @Override
    public double getMass(){
        return mass;
    }

    private void setAllignment(Alignment allignment) {
        // #TODO: Apply side (horizontal) image and vertical image.
        this.allignment = allignment;
    }

    private double totalRotationAngle = 0; // this is a variable used for alignment switching in rotation logic.
    public void rotate(double value){
        totalRotationAngle += value;
        /* Swap Allignment if the rotation value is greater than 45 degree */
        if(Math.abs(totalRotationAngle) > 45){
            switch(getAllignment()){
                case VERTICAL -> setAllignment(Alignment.HORIZONTAL);
                case HORIZONTAL -> setAllignment(Alignment.VERTICAL);
            }
            totalRotationAngle = 0;
        }

        setRotate(value + getDirection()); /* this is javafx.node method
            Now the rectangle is rotated, the ImageView is left as it is.
         */
        this.imageView.setRotate(this.getRotate());
        this.direction = getRotate();
        /*(getRotate) this is javafx.node method,
            Method in JavaFX retrieves the rotation angle in degrees of a Node relative to its parent node. */
    }

    // an overload that takes a direction from Directions enum instead of double value
    public void rotate(Directions direction){
        rotate(direction.DEGREE);
    }


/*    //    @Override // Already in rectangle
    public double getWidth() {
        return width;
    } */

    public double getLength() { // get height in rectangle
        return getHeight();
    }
 /**/

    @Override
    public String toString() {
        return "Block CenterX: " + centerX + " CenterY: " + centerY ;
    }
}

/*
*** Enhancement ***
    * inheriting from shapes.Retangle is meaningless as ImageView has all attributes needed and the Rectangle shape is set transparent anyway.
    * #TODO: rotate method is movement related, it could be moved to the Movable classes.
 */

