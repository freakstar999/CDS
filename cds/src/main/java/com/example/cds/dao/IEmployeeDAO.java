package com.example.cds.dao;

import com.example.cds.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDAO {

    Boolean insertEmployee(Employee emp);
    List<Employee> retrieveAllEmployee();
    Optional<Employee> retrieveEmployeeByID (int id);
    Boolean deleteEmployeeByID(int id);

}
