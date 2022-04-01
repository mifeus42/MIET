module com.example.proxy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proxy to javafx.fxml;
    exports com.example.proxy;
}