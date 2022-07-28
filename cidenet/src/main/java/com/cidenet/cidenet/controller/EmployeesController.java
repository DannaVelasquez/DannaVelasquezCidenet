package com.cidenet.cidenet.controller;

import java.util.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.cidenet.cidenet.Business.Business;
import com.cidenet.cidenet.Excepcions.Excepciones;
import com.cidenet.cidenet.model.EmployeesModel;
import com.cidenet.cidenet.service.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;// Service injected

    public EmployeesController() {
    }

    // Mapeo de informacion solicitada a mostrar
    @GetMapping()
    public ArrayList<EmployeesModel> getEmployees() {
        return employeesService.listEmployees();
    }

    // FILTERS
    @GetMapping(path = "/{id}")
    public Optional<EmployeesModel> getEmployeeById(@PathVariable("id") Long id) {
        return this.employeesService.listEmployeeById(id);
    }

    @GetMapping(path = "/firstName/{firstName}")
    public ArrayList<EmployeesModel> getEmployeeByFirstName(@PathVariable("firstName") String firstName) {
        return this.employeesService.listEmployeeByFirstName(firstName);
    }

    @GetMapping(path = "/otherName/{otherName}")
    public ArrayList<EmployeesModel> getEmployeeByOtherName(@PathVariable("otherName") String otherName) {
        return this.employeesService.listEmployeeByOtherName(otherName);
    }

    @GetMapping(path = "/firstLastname/{firstLastname}")
    public ArrayList<EmployeesModel> getEmployeeByFirstLastname(
            @PathVariable("firstLastname") String firstLastname) {
        return this.employeesService.listEmployeeByFirstLastname(firstLastname);
    }

    @GetMapping(path = "/secondLastname/{secondLastname}")
    public ArrayList<EmployeesModel> getEmployeeBySecondLastname(
            @PathVariable("secondLastname") String secondLastname) {
        return this.employeesService.listEmployeeBySecondLastname(secondLastname);
    }

    @GetMapping(path = "/idType/{idType}")
    public ArrayList<EmployeesModel> getEmployeeByIdType(
            @PathVariable("idType") String idType) {
        return this.employeesService.listEmployeeByIdType(idType);
    }

    @GetMapping(path = "/idNumber/{idNumber}")
    public ArrayList<EmployeesModel> getEmployeeByIdNumber(
            @PathVariable("idNumber") String idNumber) {
        return this.employeesService.listEmployeeByIdNumber(idNumber);
    }

    @GetMapping(path = "/countryE/{countryE}")
    public ArrayList<EmployeesModel> getEmployeeByCountry(@PathVariable("countryE") String countryE) {
        return this.employeesService.listEmployeeByCountry(countryE);
    }

    @GetMapping(path = "/email/{email}")
    public ArrayList<EmployeesModel> getEmployeeByEmail(
            @PathVariable("email") String email) {
        return this.employeesService.listEmployeeByEmail(email);
    }

    @GetMapping(path = "/status/{status}")
    public ArrayList<EmployeesModel> getEmployeeByStatus(@PathVariable("status") String status) {
        return this.employeesService.listEmployeeByStatus(status);
    }

    // EMPLOYEE CREATION
    @PostMapping()
    public EmployeesModel createEmployee(@Valid @RequestBody EmployeesModel employee, Errors errors) {
        if (errors.hasErrors()) {
            throwError(errors);
        }
        Business validation = new Business();
        String Msg = validation.ValidateSave(employee);
        if (Msg.isEmpty()) {
            return this.employeesService.saveEmployee(employee);
        } else {
            throw new Excepciones(Msg);
        }
    }

    // DELETE EMPLOYEE BY ID
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.employeesService.deleteEmployee(id);
        if (ok) {
            return "The user with" + id + " was removed sucessfully";
        } else {
            return "Sorry, the user with id " + id + " could not be removed";
        }
    }

    // UPDATE EMPLOYEE BY ID
    @PutMapping(value = "/{id}/update")
    public ResponseEntity<Object> updateEmpleado(@RequestBody EmployeesModel request, @PathVariable Long id) {
        this.employeesService.update(request, id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // ERRORS
    private void throwError(Errors errors) {
        String message = "";
        int index = 0;
        for (ObjectError r : errors.getAllErrors()) {
            if (index > 0) {
                message += " | ";
            }
            message += String.format("Parameter: %s - Message: %s", r.getObjectName(), r.getDefaultMessage());
        }
        throw new Excepciones(message);
    }
}
