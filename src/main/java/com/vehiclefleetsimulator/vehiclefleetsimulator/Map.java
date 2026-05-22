// Map.java
package com.vehiclefleetsimulator.vehiclefleetsimulator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class Map extends Pane {
    public static final double mapWidth  = 1800;
    public static final double mapHeight = 1000;

    // --- Spawn zones (centerX, centerY) ---
//    public static final double LAND_SPAWN_X   = 750;
//    public static final double LAND_SPAWN_Y   = mapHeight / 2;
//    public static final double WATER_SPAWN_X  = 300;
//    public static final double WATER_SPAWN_Y  = mapHeight / 2;
//    public static final double AIR_SPAWN_X    = 1550;
//    public static final double AIR_SPAWN_Y    = mapHeight / 2;

    // Land vehicle spawn points (road zone: x 600-1300)
    public static final List<double[]> LAND_SPAWN_POINTS = new ArrayList<>(List.of(
            new double[]{650,  100},
            new double[]{650,  250},
            new double[]{650,  400},
            new double[]{650,  550},
            new double[]{650,  700},
            new double[]{650,  850},
            new double[]{750,  100},
            new double[]{750,  250},
            new double[]{750,  400},
            new double[]{750,  550},
            new double[]{750,  700},
            new double[]{750,  850},
            new double[]{850,  100},
            new double[]{850,  250},
            new double[]{850,  400},
            new double[]{850,  550},
            new double[]{850,  700},
            new double[]{850,  850}
    ));

    // Water vehicle spawn points (sea zone: x 0-600)
    public static final List<double[]> WATER_SPAWN_POINTS = new ArrayList<>(List.of(
            new double[]{100,  150},
            new double[]{100,  350},
            new double[]{100,  550},
            new double[]{100,  750},
            new double[]{250,  150},
            new double[]{250,  350},
            new double[]{250,  550},
            new double[]{250,  750},
            new double[]{400,  150},
            new double[]{400,  350},
            new double[]{400,  550},
            new double[]{400,  750}
    ));

    // Air vehicle spawn points (airport zone: x 1300-1800)
    public static final List<double[]> AIR_SPAWN_POINTS = new ArrayList<>(List.of(
            new double[]{1350, 150},
            new double[]{1350, 350},
            new double[]{1350, 550},
            new double[]{1350, 750},
            new double[]{1500, 150},
            new double[]{1500, 350},
            new double[]{1500, 550},
            new double[]{1500, 750},
            new double[]{1650, 150},
            new double[]{1650, 350},
            new double[]{1650, 550},
            new double[]{1650, 750}
    ));

    ImageView seaBG    = new ImageView(new Image(getClass().getResourceAsStream("Assets/sea.png")));
    ImageView roadBG   = new ImageView(new Image(getClass().getResourceAsStream("Assets/road.png")));
    ImageView airportBG= new ImageView(new Image(getClass().getResourceAsStream("Assets/airport.png")));

    Building building1 = new Building(950, 300, 250, 250, new Image(getClass().getResourceAsStream("Assets/building.png")));
    Building building2 = new Building(950, 700, 250, 250, new Image(getClass().getResourceAsStream("Assets/building.png")));

    Block barrier1      = new Barrier(600,          mapHeight / 2, mapHeight, Barrier.SEA_BARRIER_IMAGE, Barrier.TYPES.REGULAR);
    Block barrier2      = new Barrier(1300,         mapHeight / 2, mapHeight, 20, Barrier.TYPES.REGULAR);
    Block topBarrier    = new Barrier(mapWidth / 2, 0,             mapWidth, Barrier.TYPES.EDGE);
    Block bottomBarrier = new Barrier(mapWidth / 2, mapHeight,     mapWidth, Barrier.TYPES.EDGE);
    Block leftBarrier      = new Barrier(5,         mapHeight / 2, mapHeight, 10, Barrier.TYPES.EDGE);
    Block rightBarrier      = new Barrier(mapWidth - 5,         mapHeight / 2, mapHeight, 10, Barrier.TYPES.EDGE);

    List<TurningPoint> turningPoints = new ArrayList<>(List.of(
            // Road corners
//            new TurningPoint(683,  50,  0, 60, Directions.RIGHT),
//            new TurningPoint(1217, 50,  0, 60, Directions.RIGHT),
//            new TurningPoint(683,  950, 0, 60, Directions.RIGHT),
//            new TurningPoint(1217, 950, 0, 60, Directions.RIGHT)
//
//            // Sea corners
////            new TurningPoint(0,   50,  0, 40, Directions.LEFT),
////            new TurningPoint(600, 50,  0, 40, Directions.RIGHT),
//            new TurningPoint(0,   950, 0, 40, Directions.RIGHT),
////            new TurningPoint(600, 950, 0, 40, Directions.LEFT),
//
//            // Map corners (air vehicles)
//            new TurningPoint(0,        0,         100, 2, Directions.RIGHT),
//            new TurningPoint(mapWidth, 0,         100, 2, Directions.LEFT),
//            new TurningPoint(0,        mapHeight, 100, 2, Directions.LEFT),
//            new TurningPoint(mapWidth, mapHeight, 100, 2, Directions.RIGHT),
//
//            // Airport take-off point (ground level, center of airport)
//            new TurningPoint(AIR_SPAWN_X, AIR_SPAWN_Y, 0,
//                    40, Directions.RIGHT, TurningPoint.Type.TAKE_OFF, 2),
//
//            // Airport landing point (at max altitude, triggers descent)
//            new TurningPoint(AIR_SPAWN_X, AIR_SPAWN_Y, AirVehicle.MAX_ALTITUDE,
//                    40, Directions.RIGHT, TurningPoint.Type.LAND, -2),
//
//            // Hold altitude point (huge radius at cruise altitude)
//            new TurningPoint(mapWidth / 2, mapHeight / 2, AirVehicle.MAX_ALTITUDE,
//                    500, Directions.RIGHT, TurningPoint.Type.HOLD_ALT, 0)
    ));

    public Map() {
        seaBG.setFitWidth(600);
        seaBG.setFitHeight(1000);
        seaBG.setX(0);
        seaBG.setY(0);

        roadBG.setFitWidth(700);
        roadBG.setFitHeight(1000);
        roadBG.setX(600);
        roadBG.setY(0);

        airportBG.setFitWidth(500);
        airportBG.setFitHeight(1000);
        airportBG.setX(1300);
        airportBG.setY(0);


        topBarrier.rotate(Directions.LEFT);
        bottomBarrier.rotate(Directions.RIGHT);

        this.getChildren().addAll(
                seaBG, roadBG, airportBG,
                building1, building2,
                building1.imageView, building2.imageView,
                barrier1, barrier2,
                barrier1.imageView, barrier2.imageView,
                topBarrier, topBarrier.imageView,
                bottomBarrier, bottomBarrier.imageView,
                rightBarrier, rightBarrier.imageView,
                leftBarrier, leftBarrier.imageView
        );
    }

    static class Barrier extends Block {
        public final TYPES TYPE;
        public static final Image BARRIER_IMAGE =
                new Image(Map.class.getResourceAsStream("Assets/barrier.png"));
        public static final Image SEA_BARRIER_IMAGE =
                new Image(Map.class.getResourceAsStream("Assets/seaBarrier.png"));

        Barrier(double centerX, double centerY, double length, TYPES type) {
            super(centerX, centerY, 40, length, BARRIER_IMAGE, 9999);
            TYPE = type;
        }
        Barrier(double centerX, double centerY, double length, Image image, TYPES type) {
            super(centerX, centerY, 40, length, image, 9999);
            TYPE = type;
        }
        Barrier(double centerX, double centerY, double length, double width, TYPES type) {
            super(centerX, centerY, width, length, BARRIER_IMAGE, 9999);
            TYPE = type;
        }

        @Override
        public void setCenterZ(double z) {} // immovable

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

        enum TYPES{
            EDGE,
            REGULAR;
        }
    }
}