package com.example.cds.api;

import com.example.cds.model.Employee;
import com.example.cds.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("employee")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void insertEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @GetMapping
    public List<Employee> retrieveAllValidEmployee() {
        return employeeService.retrieveAllValidEmployee();
    }

    @GetMapping(path = "{id}")
    public Employee retrieveEmployeeByID(@PathVariable("id") int id) { return employeeService.retrieveEmployeeByID(id).orElse(null); }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployeeByID(id);
    }
}
