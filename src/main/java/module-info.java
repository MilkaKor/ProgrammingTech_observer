module com.example.programmingtech_observable {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.programmingtech_observable to javafx.fxml;
    exports com.example.programmingtech_observable;
}