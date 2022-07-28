package com.cidenet.cidenet.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cidenet.cidenet.Business.Business;
import com.cidenet.cidenet.model.EmployeesModel;
import com.cidenet.cidenet.repository.EmployeesRepository;

@Service
public class EmployeesService {

    public EmployeesService() {
    }

    @Autowired
    EmployeesRepository employeesRepository;// Service injected

    public ArrayList<EmployeesModel> listEmployees() {
        return (ArrayList<EmployeesModel>) employeesRepository.findAll();
    }

    public Optional<EmployeesModel> listEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }

    public EmployeesModel saveEmployee(EmployeesModel request) {
        Business bus = new Business();
        EmployeesModel employee = request;

        employee.setEmail(bus.generateEmail(request)); // generacion de correo automatico al crear empleado
        employee.setRegistrationDateTime(bus.generateRegistrationDate()); // generacion de fecha de registro al crear
                                                                          // empleado
        return employeesRepository.save(employee);
    }

    public ArrayList<EmployeesModel> listEmployeeByFirstName(String firstName) {
        return employeesRepository.findByFirstName(firstName);
    }

    public ArrayList<EmployeesModel> listEmployeeByOtherName(String otherName) {
        return employeesRepository.findByOtherName(otherName);
    }

    public ArrayList<EmployeesModel> listEmployeeByFirstLastname(String firstLastname) {
        return employeesRepository.findByFirstLastname(firstLastname);
    }

    public ArrayList<EmployeesModel> listEmployeeBySecondLastname(String secondLastname) {
        return employeesRepository.findBySecondLastname(secondLastname);
    }

    public ArrayList<EmployeesModel> listEmployeeByIdType(String idType) {
        return employeesRepository.findByIdType(idType);
    }

    public ArrayList<EmployeesModel> listEmployeeByIdNumber(String idNumber) {
        return employeesRepository.findByIdNumber(idNumber);
    }

    public ArrayList<EmployeesModel> listEmployeeByCountry(String countryE) {
        return employeesRepository.findByCountryE(countryE);
    }

    public ArrayList<EmployeesModel> listEmployeeByEmail(String email) {
        return employeesRepository.findByEmail(email);
    }

    public ArrayList<EmployeesModel> listEmployeeByStatus(String status) {
        return employeesRepository.findByStatus(status);
    }

    // Excepcion para validacion de empleado eliminado
    public boolean deleteEmployee(Long id) {
        try {
            employeesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Metodo para actualizar datos de los empleados
    public void update(EmployeesModel request, long id) {
        Business bus = new Business();
        Optional<EmployeesModel> employees = this.employeesRepository.findById(id);
        EmployeesModel employee = employees.get();
        employee.setFirstLastname(request.getFirstLastname());
        employee.setSecondLastname(request.getSecondLastname());
        employee.setFirstName(request.getFirstName());
        employee.setOtherName(request.getOtherName());
        employee.setIdType(request.getIdType());
        employee.setIdNumber(request.getIdNumber());
        employee.setCountryE(request.getCountryE());
        employee.setEmail(bus.generateEmail(request));
        employee.setAdmissionDate(request.getAdmissionDate());
        employee.setAreaEmployee(request.getAreaEmployee());
        employee.setUpdatingDateTime(bus.generateUpdatingDate());
        this.employeesRepository.save(employee);

    }

}