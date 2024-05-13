package com.example.ihmsf.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;// Clinic.java


public class Clinic {
    private final StringProperty clinicID;
    private final StringProperty clinicSpeciality;

    public Clinic(String clinicName, String clinicSpeciality) {
        this.clinicID = new SimpleStringProperty(clinicName);
        this.clinicSpeciality = new SimpleStringProperty(clinicSpeciality);
    }

    public StringProperty getClinicID() {
        return clinicID;
    }
    public StringProperty getClinicSpeciality() {
        return clinicSpeciality;
    }
}

