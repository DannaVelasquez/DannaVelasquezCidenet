package com.cidenet.cidenet.Business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import com.cidenet.cidenet.model.EmployeesModel;

public class Business {

    // VALIDATION - COUNTRY
    public boolean ValidateCountryEmploy(String countryE) {
        ArrayList countries = new ArrayList();
        countries.add("Colombia");
        countries.add("United States");

        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).equals(countryE)) {
                return true;
            }
        }
        return false;
    }

    // VALIDATION - ID TYPE
    public boolean ValidateIdType(String idType) {
        ArrayList type = new ArrayList();
        type.add("Cedula de Ciudadania");
        type.add("Cedula de Extranjeria");
        type.add("Pasaporte");
        type.add("Permiso Especial");

        for (int i = 0; i < type.size(); i++) {
            if (type.get(i).equals(idType)) {
                return true;
            }
        }
        return false;
    }

    // VALIDATION - COMPANY AREAS
    public boolean ValidateAreas(String areaEmployee) {
        ArrayList area = new ArrayList();
        area.add("Administracion");
        area.add("Financiera");
        area.add("Compras");
        area.add("Infraestructura");
        area.add("Operacion");
        area.add("Talento Humano");
        area.add("Servicios Varios");

        for (int i = 0; i < area.size(); i++) {
            if (area.get(i).equals(areaEmployee)) {
                return true;
            }
        }
        return false;
    }

    // GENERATE EMAIL
    public String generateEmail(EmployeesModel model) {

        String Id = "";
        String email = "";
        String[] existingMail = email.split("\\.");
        boolean exists = false;
        int i = 1;
        String dom;

        if (!email.isEmpty()) {
            exists = existingMail[2].contains("@cidenet");
            Id = String.valueOf(i);
        }

        if (exists) {
            char[] Num = existingMail[2].toCharArray();
            i = Character.getNumericValue(Num[0]) + 1;
            Id = String.valueOf(i);
        }

        Id = Id.isEmpty() ? "" : "." + Id;

        if (model.getCountryE().equals("Colombia")) {
            dom = "co";
        } else {
            dom = "us";
        }

        String emailG = model.getFirstName() + "." + model.getFirstLastname() + Id + "@" + "cidenet.com." + dom;

        return emailG.toLowerCase().replace(" ", "");// ajusta formato del email

    }

    // Genera la fecha para el campo de registro al momento de crear un empleado
    public LocalDateTime generateRegistrationDate() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");// genera el formato solicitado
        String actualDateTime = format.format(LocalDateTime.now());

        LocalDateTime registerDateTime = LocalDateTime.parse(actualDateTime, format);

        return registerDateTime;
    }

    // Genera la fecha para el campo de edicion al actualizar un empleado
    public LocalDateTime generateUpdatingDate() {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");// genera el formato solicitado
        String actualDateTime = format.format(LocalDateTime.now());

        LocalDateTime updateDateTime = LocalDateTime.parse(actualDateTime, format);

        return updateDateTime;
    }

    // VALIDATE ADMISSION DATE (valida que la fecha de ingreso cumpla con lo
    // requerido)
    public boolean ValidateAdmissionDate(LocalDate admissionDate) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String actualDate = format.format(LocalDate.now());
        String admissionDateS = format.format(admissionDate);

        LocalDate actualDateLD = LocalDate.parse(actualDate, format);
        LocalDate admissionDateLD = LocalDate.parse(admissionDateS, format);

        long diffInDays = ChronoUnit.DAYS.between(admissionDateLD, actualDateLD);

        if (diffInDays > 30 || admissionDateLD.isAfter(actualDateLD)) {
            return false;
        }

        return true;

    }

    // VALIDATION - SAVE INFORMATION (validaciones a tener en cuenta antes de
    // guardar el empleado)
    public String ValidateSave(EmployeesModel model) {
        String message = "";
        if (!ValidateCountryEmploy(model.getCountryE())) {
            message = "Sorry, the country doesn't exist.";
        }

        if (!ValidateIdType(model.getIdType())) {
            message = message + "Sorry, Id type doesn't exist.";
        }

        if (!ValidateAreas(model.getAreaEmployee())) {
            message = message + "Sorry, the area doesn't exist.";
        }
        if (!ValidateAdmissionDate(model.getAdmissionDate())) {
            message = message + "Sorry, the admission date is after actual day or exceed the month";
        }
        return message;
    }
}
