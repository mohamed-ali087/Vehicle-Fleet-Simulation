// Testing.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

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

    @Override
    public void start(Stage stage) throws Exception {
        Map root = new Map();
        Scene scene = new Scene(root, root.mapWidth, root.mapHeight);

        List<Vehicle> allVehicles = new ArrayList<>();

        // --- Land vehicles (spawn on road) ---
        int c = 0;
        for (int i = 0; i < 2; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Car.Builder()
                    .setCenterX(spawn[0] + 42 * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * 120) - 120)
                    .setCenterZ(0).setMass(50).speed(5).direction(0).acceleration(0.009)
                    .build());
        }
        for (int i = 0; i < 1; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c * 2);
            ++c;
            allVehicles.add(new Truck.Builder()
                    .setCenterX(spawn[0] + 42 * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * 120) - 120)
                    .setCenterZ(0).setMass(200).speed(3).direction(0).acceleration(0.005)
                    .build());
        }
        for (int i = 0; i < 1; i++) {
            double[] spawn = Map.LAND_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Motorcycle.Builder()
                    .setCenterX(spawn[0] + 42 * ((Math.random() > 0.5) ? 1 : -1))
                    .setCenterY(spawn[1] + (i * 120) - 120)
                    .setCenterZ(0).setMass(20).speed(7).direction(0).acceleration(0.007)
                    .build());
        }

        // --- Water vehicles (spawn on sea) ---
        for (int i = 0; i < 1; i++) {
            double[] spawn = Map.WATER_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Submarine.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * 150) - 75)
                    .setCenterZ(0).setMass(500).speed(2).direction(0).acceleration(0.0005)
                    .build());
        }
        for (int i = 0; i < 2; i++) {
            double[] spawn = Map.WATER_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Boat.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * 150) - 75)
                    .setCenterZ(0).setMass(300).speed(3).direction(0).acceleration(0.001)
                    .build());
        }

        // --- Air vehicles (spawn at airport) ---
        for (int i = 0; i < 2; i++) {
            double[] spawn = Map.AIR_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Drone.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * 100) - 50)
                    .setCenterZ(0).setMass(10).speed(0.0005).direction(0).vZ(0.01).acceleration(0.0005)
                    .build());
        }
        for (int i = 0; i < 1; i++) {
            double[] spawn = Map.AIR_SPAWN_POINTS.get(c);
            ++c;
            allVehicles.add(new Helicopter.Builder()
                    .setCenterX(spawn[0])
                    .setCenterY(spawn[1] + (i * 100) - 50)
                    .setCenterZ(0).setMass(800).speed(0.001).direction(0).vZ(0.1).acceleration(0.0005)
                    .build());
        }

        // add all to scene
        for (Vehicle v : allVehicles) {
            v.setStroke(Color.TRANSPARENT);
            v.setFill(Color.TRANSPARENT);
            v.calculateNextPoint();
            v.update();
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