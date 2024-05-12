package com.example.ihmsf.Models;

public class Patient {
    private String BirthDate;
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String address;
    private String bloodType;
    private String hospitalID;
    private String SSN;

//    public Patient(String id, String name, String gender, String phone, String address, String bloodType, String BirthDate, String hospitalID) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.bloodType = bloodType;
//        this.BirthDate = BirthDate;
//        this.hospitalID = hospitalID;
//
//    }
//    public Patient( String name, String gender, String phone, String address, String bloodType, String BirthDate, String hospitalID, String SSN) {
//        this.name = name;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.bloodType = bloodType;
//        this.BirthDate = BirthDate;
//        this.hospitalID = hospitalID;
//        this.SSN = SSN;
//    }

//    public Patient(String id, String name, String gender, String phone, String address, String bloodType, String BirthDate, String hospitalID, String SSN) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.bloodType = bloodType;
//        this.BirthDate = BirthDate;
//        this.hospitalID = hospitalID;
//        this.SSN = SSN;
//    }

//
//    }
//    public Patient(String name, String gender, String phone, String address, String bloodType, String BirthDate, String hospitalID, String SSN) {
//        this.name = name;
//        this.gender = gender;
//        this.phone = phone;
//        this.address = address;
//        this.bloodType = bloodType;
//        this.BirthDate = BirthDate;
//        this.hospitalID = hospitalID;
//        this.SSN = SSN;
//    }





    public Patient(String id, String name, String gender, String phone, String address, String bloodType, String birthDate, String hospitalID, String SSN) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.bloodType = bloodType;
        this.BirthDate = birthDate;
        this.hospitalID = hospitalID;
        this.SSN = SSN;
    }

    // Constructor without id field (for creating new patients)
    public Patient(String name, String gender, String phone, String address, String bloodType, String birthDate, String hospitalID, String SSN) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.bloodType = bloodType;
        this.BirthDate = birthDate;
        this.hospitalID = hospitalID;
        this.SSN = SSN;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBirthDate() {
        return BirthDate;
    }
    public String getHospitalID() {
        return hospitalID;
    }
    public String getSSN() {
        return SSN;
    }
}



