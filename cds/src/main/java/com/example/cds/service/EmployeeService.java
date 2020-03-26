package com.example.cds.service;

import com.example.cds.dao.IEmployeeDAO;
import com.example.cds.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private IEmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(@Qualifier("internalDB") IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Boolean insertEmployee(Employee employee) {
        return employeeDAO.insertEmployee(employee);
    }

    public List<Employee> retrieveAllValidEmployee() {
        return employeeDAO.retrieveAllEmployee()
                .stream()
                .filter(employee -> employee.getSalary().doubleValue() >= 0 && employee.getSalary().doubleValue() <= 4000)
                .collect(Collectors.toList());
    }

    public Optional<Employee> retrieveEmployeeByID(int id) {
        return employeeDAO.retrieveEmployeeByID(id);
    }

    public Boolean deleteEmployeeByID(int id) {
        return employeeDAO.deleteEmployeeByID(id);
    }
}
