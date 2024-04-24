module com.example.ihmsf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.example.ihmsf to javafx.fxml;
    exports com.example.ihmsf;
    exports com.example.ihmsf.Controllers;
    exports com.example.ihmsf.Controllers.Doctor;
    exports com.example.ihmsf.Controllers.Receptionist;
    exports com.example.ihmsf.Controllers.Blood;
    exports com.example.ihmsf.Controllers.Radiology;
    exports com.example.ihmsf.Models;
    exports com.example.ihmsf.Views;

}