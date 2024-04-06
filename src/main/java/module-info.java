module com.example.ihmsf {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ihmsf to javafx.fxml;
    exports com.example.ihmsf;
}