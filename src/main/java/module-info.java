module com.vehiclefleetsimulator.vehiclefleetsimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.vehiclefleetsimulator.vehiclefleetsimulator to javafx.fxml;
    exports com.vehiclefleetsimulator.vehiclefleetsimulator;
}