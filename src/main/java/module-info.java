module com.example.ihmsf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.ihmsf to javafx.fxml;
    exports com.example.ihmsf;
}