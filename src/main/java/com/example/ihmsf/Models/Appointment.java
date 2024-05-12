package com.example.ihmsf.Models;

import java.time.LocalDate;

public class Appointment {
    private String speciality;
    private String patientID;
    private String patientName;
    private String appointmentID;
    private LocalDate date;
    private String doctorName;
    private String clinic;
    private String hospital;
    private String room;
    private Doctor selectedDoctor;



public Appointment(String speciality, String patientID, String patientName, String appointmentID, LocalDate date, String doctorName, String clinic, String hospital, String room, Doctor selectedDoctor) {
    this.speciality = speciality;
    this.patientID = patientID;
    this.patientName = patientName;
    this.appointmentID = appointmentID;
    this.date = date;
    this.doctorName = doctorName;
    this.clinic = clinic;
    this.hospital = hospital;
    this.room = room;
    this.selectedDoctor = selectedDoctor;
}

    // getters and setters



    public String getType() { return speciality; }
    public String getStatus() { return "Pending"; }
    public String getTimeSlot() { return "10:00 AM"; }
    public String getDoctorId() { return selectedDoctor.getDoctorID().get(); }
    public String getPatientId() { return patientID; }
    public String getDateTime() { return date.toString(); }


    public String getSpeciality() { return speciality; }
    public String getPatientID() { return patientID; }
    public String getPatientName() { return patientName; }
    public String getAppointmentID() { return appointmentID; }
    public LocalDate getAppointmentDate() { return date; }
    public String getDoctorName() { return doctorName; }
    public String getClinic() { return clinic; }
    public String getHospital() { return hospital; }
    public String getRoom() { return room; }
    public Doctor getSelectedDoctor() { return selectedDoctor; }

    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public void setPatientID(String patientID) { this.patientID = patientID; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setAppointmentID(String appointmentID) { this.appointmentID = appointmentID; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
    public void setClinic(String clinic) { this.clinic = clinic; }
    public void setHospital(String hospital) { this.hospital = hospital; }
    public void setRoom(String room) { this.room = room; }
    public void setSelectedDoctor(Doctor selectedDoctor) { this.selectedDoctor = selectedDoctor; }

}
