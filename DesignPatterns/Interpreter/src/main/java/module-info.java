module com.example.interpreter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interpreter to javafx.fxml;
    exports com.example.interpreter;
}