module com.vehiclefleetsimulator.vehiclefleetsimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.vehiclefleetsimulator.vehiclefleetsimulator to javafx.fxml;
    exports com.vehiclefleetsimulator.vehiclefleetsimulator;
    exports com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle;
    opens com.vehiclefleetsimulator.vehiclefleetsimulator.vehicle to javafx.fxml;
    exports com.vehiclefleetsimulator.vehiclefleetsimulator.map;
    opens com.vehiclefleetsimulator.vehiclefleetsimulator.map to javafx.fxml;
    exports com.vehiclefleetsimulator.vehiclefleetsimulator.core;
    opens com.vehiclefleetsimulator.vehiclefleetsimulator.core to javafx.fxml;
}