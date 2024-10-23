module com.example.nhahangkkts_nhom10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens gui to javafx.fxml;
    exports gui;
    exports control;
    opens control to javafx.fxml;
}