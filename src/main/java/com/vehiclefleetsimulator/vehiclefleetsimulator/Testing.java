// Testing.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

import com.vehiclefleetsimulator.vehiclefleetsimulator.core.Movable;
import com.vehiclefleetsimulator.vehiclefleetsimulator.map.Map;
import com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class Testing extends Application {

    // Spawn defaults
// Land
    private static final int    CAR_COUNT        = 2;
    private static final double CAR_MASS         = 50;
    private static final double CAR_SPEED        = 5;
    private static final double CAR_ACCEL        = 0.009;

    private static final int    TRUCK_COUNT      = 1;
    private static final double TRUCK_MASS       = 200;
    private static final double TRUCK_SPEED      = 3;
    private static final double TRUCK_ACCEL      = 0.005;

    private static final int    MOTO_COUNT       = 1;
    private static final double MOTO_MASS        = 20;
    private static final double MOTO_SPEED       = 7;
    private static final double MOTO_ACCEL       = 0.007;

    // Water
    private static final int    SUBMARINE_COUNT  = 1;
    private static final double SUBMARINE_MASS   = 500;
    private static final double SUBMARINE_SPEED  = 2;
    private static final double SUBMARINE_ACCEL  = 0.0005;

    private static final int    BOAT_COUNT       = 2;
    private static final double BOAT_MASS        = 300;
    private static final double BOAT_SPEED       = 3;
    private static final double BOAT_ACCEL       = 0.001;

    // Air
    private static final int    DRONE_COUNT      = 2;
    private static final double DRONE_MASS       = 10;
    private static final double DRONE_SPEED      = 0.0005;
    private static final double DRONE_VZ         = 0.01;
    private static final double DRONE_ACCEL      = 0.0005;

    private static final int    HELICOPTER_COUNT = 1;
    private static final double HELICOPTER_MASS  = 800;
    private static final double HELICOPTER_SPEED = 0.001;
    private static final double HELICOPTER_VZ    = 0.1;
    private static final double HELICOPTER_ACCEL = 0.0005;

    // Shared
    private static final double LAND_X_OFFSET    = 42;
    private static final double LAND_Y_SPACING   = 120;
    private static final double WATER_Y_SPACING  = 150;
    private static final double AIR_Y_SPACING    = 100;

    @Override
    public void start(Stage stage) throws Exception {
        Map root = new Map();
        Scene scene = new Scene(root, Map.mapWidth, Map.mapHeight);

        List<Vehicle> allVehicles = new ArrayList<>();

        // Land vehicles (spawn on road)
        int c = 0;
        for (int i = 0; i < CAR_COUNT; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Car.Builder()
                    .setCenterX(spawn[0] + LAND_X_OFFSET * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * LAND_Y_SPACING) - LAND_Y_SPACING)
                    .setCenterZ(0).setMass(CAR_MASS).speed(CAR_SPEED).direction(0).acceleration(CAR_ACCEL)
                    .build());
        }
        for (int i = 0; i < TRUCK_COUNT; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c * 2);
            ++c;
            allVehicles.add(new Truck.Builder()
                    .setCenterX(spawn[0] + LAND_X_OFFSET * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * LAND_Y_SPACING) - LAND_Y_SPACING)
                    .setCenterZ(0).setMass(TRUCK_MASS).speed(TRUCK_SPEED).direction(0).acceleration(TRUCK_ACCEL)
                    .build());
        }
        for (int i = 0; i < MOTO_COUNT; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Motorcycle.Builder()
                    .setCenterX(spawn[0] + LAND_X_OFFSET * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * LAND_Y_SPACING) - LAND_Y_SPACING)
                    .setCenterZ(0).setMass(MOTO_MASS).speed(MOTO_SPEED).direction(0).acceleration(MOTO_ACCEL)
                    .build());
        }

// Water vehicles (spawn on sea)
        for (int i = 0; i < SUBMARINE_COUNT; i++) {
            double[] spawn = Map.WATER_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Submarine.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * WATER_Y_SPACING) - WATER_Y_SPACING / 2)
                    .setCenterZ(0).setMass(SUBMARINE_MASS).speed(SUBMARINE_SPEED).direction(0).acceleration(SUBMARINE_ACCEL)
                    .build());
        }
        for (int i = 0; i < BOAT_COUNT; i++) {
            double[] spawn = Map.WATER_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Boat.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * WATER_Y_SPACING) - WATER_Y_SPACING / 2)
                    .setCenterZ(0).setMass(BOAT_MASS).speed(BOAT_SPEED).direction(0).acceleration(BOAT_ACCEL)
                    .build());
        }

//  Air vehicles (spawn at airport)
        for (int i = 0; i < DRONE_COUNT; i++) {
            double[] spawn = Map.AIR_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Drone.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * AIR_Y_SPACING) - AIR_Y_SPACING / 2)
                    .setCenterZ(0).setMass(DRONE_MASS).speed(DRONE_SPEED).direction(0).vZ(DRONE_VZ).acceleration(DRONE_ACCEL)
                    .build());
        }
        for (int i = 0; i < HELICOPTER_COUNT; i++) {
            double[] spawn = Map.AIR_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Helicopter.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * AIR_Y_SPACING) - AIR_Y_SPACING / 2)
                    .setCenterZ(0).setMass(HELICOPTER_MASS).speed(HELICOPTER_SPEED).direction(0).vZ(HELICOPTER_VZ).acceleration(HELICOPTER_ACCEL)
                    .build());
        }

        // add all to scene
        for (Vehicle v : allVehicles) {
            v.setStroke(Color.TRANSPARENT);
            v.setFill(Color.TRANSPARENT);
            v.calculateNextPoint();
            v.update();
            v.rotate(0);
            root.getChildren().addAll(v, v.imageView);
        }

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(Movable.ANIMATION_PERIODIC_TIME), e -> {
            for (Vehicle v : allVehicles) {
                v.calculateNextPoint();
                v.update();
            }
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        stage.setResizable(false);
        stage.setTitle("Vehicle Fleet Simulator");
        stage.setScene(scene);
        stage.show();
    }

    static void main() {
        launch();
    }
}