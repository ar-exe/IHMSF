package com.example.ihmsf.Models;

import java.time.LocalDate;

public class Appointment {
    private String speciality;
    private String patientID;
    private LocalDate date;
    private Doctor selectedDoctor;

    public Appointment(String speciality, String patientID, LocalDate date, Doctor selectedDoctor) {
        this.speciality = speciality;
        this.patientID = patientID;
        this.date = date;
        this.selectedDoctor = selectedDoctor;
    }

    // getters and setters
    public String getSpeciality() { return speciality; }
    public String getPatientID() { return patientID; }
    public LocalDate getDate() { return date; }
    public Doctor getSelectedDoctor() { return selectedDoctor; }
    public String getType() { return speciality; }
    public String getStatus() { return "Pending"; }
    public String getTimeSlot() { return "10:00 AM"; }
    public String getDoctorId() { return selectedDoctor.getDoctorID().get(); }
    public String getPatientId() { return patientID; }
    public String getDateTime() { return date.toString(); }

    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public void setPatientID(String patientID) { this.patientID = patientID; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setSelectedDoctor(Doctor selectedDoctor) { this.selectedDoctor = selectedDoctor; }
}
