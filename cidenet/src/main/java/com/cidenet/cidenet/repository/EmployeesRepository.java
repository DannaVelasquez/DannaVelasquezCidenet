package com.cidenet.cidenet.repository;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.cidenet.cidenet.model.EmployeesModel;

public interface EmployeesRepository extends CrudRepository<EmployeesModel, Long> {

    public abstract ArrayList<EmployeesModel> findByFirstName(String firstName);

    public abstract ArrayList<EmployeesModel> findByOtherName(String otherName);

    public abstract ArrayList<EmployeesModel> findByFirstLastname(String firstLastname);

    public abstract ArrayList<EmployeesModel> findBySecondLastname(String secondLastname);

    public abstract ArrayList<EmployeesModel> findByIdType(String idType);

    public abstract ArrayList<EmployeesModel> findByIdNumber(String idNumber);

    public abstract ArrayList<EmployeesModel> findByCountryE(String countryE);

    public abstract ArrayList<EmployeesModel> findByEmail(String email);

    public abstract ArrayList<EmployeesModel> findByStatus(String status);
}
