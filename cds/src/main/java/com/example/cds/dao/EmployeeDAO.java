package com.example.cds.dao;

import com.example.cds.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("internalDB")
public class EmployeeDAO implements IEmployeeDAO {

    private static List<Employee> db = new  ArrayList<>();

    @Override
    public Boolean insertEmployee(Employee emp) {
        Optional<Employee> employee = Optional.ofNullable(emp);
        if (employee.isPresent()) {
            db.add(new Employee(emp.getId(), emp.getName(), emp.getSalary()));
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> retrieveAllEmployee() {
            return db;
    }

    @Override
    public Optional<Employee> retrieveEmployeeByID(int id) {
        return db.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst();
    }

    @Override
    public Boolean deleteEmployeeByID(int id) {
        Optional<Employee> emp = retrieveEmployeeByID(id);
        if(emp.isPresent()) {
            db.remove(emp.get());
            return true;
        }
        return false;
    }
}
