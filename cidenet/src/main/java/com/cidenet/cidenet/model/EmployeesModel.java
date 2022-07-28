package com.cidenet.cidenet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.*;

//CREATION A TABLE ON A DATABASE
@Entity
@Table(name = "employees")
public class EmployeesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Pattern(regexp = "[A-Z ]*$", message = "The first last name should contain letters from A to Z and uppercase")
    @NotEmpty(message = "The first last name is mandatory")
    @Size(max = 20, message = "The first lastname should contain 20 letters max")
    private String firstLastname;

    @Pattern(regexp = "[A-Z]*$", message = "The second last name should contain letters from A to Z and uppercase")
    @NotEmpty(message = "The second last name is mandatory")
    @Size(max = 20, message = "The second lastname should contain 20 letters max")
    private String secondLastname;

    @Pattern(regexp = "[A-Z]*$", message = "The first name should contain letters from A to Z and uppercase")
    @NotEmpty(message = "The first name is mandatory")
    @Size(max = 20, message = "The first name should contain 20 letters max")
    private String firstName;

    @Pattern(regexp = "[A-Z ]*$", message = "The first name should contain letters from A to Z and uppercase")
    @Size(max = 50, message = "The name should contain 50 letters max")
    private String otherName;

    private String idType;

    @Pattern(regexp = "^[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*$", message = "The id number should contain alphanumeric characters")
    @Size(max = 20, message = "The id number should contain 20 letters max")
    private String idNumber;

    private String countryE;

    @Size(max = 300, message = "The email should contain 300 characters")
    private String email;
    private LocalDate admissionDate;
    private String areaEmployee;
    private final String status = "Active";
    private LocalDateTime registrationDateTime;
    private LocalDateTime updatingDateTime;

    // Constructors
    public EmployeesModel() {
    }

    public EmployeesModel(Long id,
            @Pattern(regexp = "[A-Z ]*$", message = "The first last name should contain letters from A to Z and uppercase") @NotEmpty(message = "The first last name is mandatory") @Size(max = 20, message = "The first lastname should contain 20 letters max") String firstLastname,
            @Pattern(regexp = "[A-Z]*$", message = "The second last name should contain letters from A to Z and uppercase") @NotEmpty(message = "The second last name is mandatory") @Size(max = 20, message = "The second lastname should contain 20 letters max") String secondLastname,
            @Pattern(regexp = "[A-Z]*$", message = "The first name should contain letters from A to Z and uppercase") @NotEmpty(message = "The first name is mandatory") @Size(max = 20, message = "The first name should contain 20 letters max") String firstName,
            @Pattern(regexp = "[A-Z ]*$", message = "The first name should contain letters from A to Z and uppercase") @Size(max = 50, message = "The name should contain 50 letters max") String otherName,
            String idType,
            @Pattern(regexp = "^[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*$", message = "The id number should contain alphanumeric characters") @Size(max = 20, message = "The id number should contain 20 letters max") String idNumber,
            String countryE, @Size(max = 300, message = "The email should contain 300 characters") String email,
            LocalDate admissionDate, String areaEmployee, LocalDateTime registrationDateTime) {
        this.id = id;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.firstName = firstName;
        this.otherName = otherName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.countryE = countryE;
        this.email = email;
        this.admissionDate = admissionDate;
        this.areaEmployee = areaEmployee;
        this.registrationDateTime = registrationDateTime;
    }

    // Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCountryE() {
        return countryE;
    }

    public void setCountryE(String countryE) {
        this.countryE = countryE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAreaEmployee() {
        return areaEmployee;
    }

    public void setAreaEmployee(String areaEmployee) {
        this.areaEmployee = areaEmployee;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }

    public LocalDateTime getUpdatingDateTime() {
        return updatingDateTime;
    }

    public void setUpdatingDateTime(LocalDateTime updatingDateTime) {
        this.updatingDateTime = updatingDateTime;
    }

}