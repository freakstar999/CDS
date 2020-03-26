package com.example.cds.dao;

import com.example.cds.model.Employee;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOTest {

    @Test
    @Order (1)
    public void insertEmployeePass() {
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee = new Employee(101, "TestInsertEmployee1", BigDecimal.valueOf(1234.56));
        Boolean result = dao.insertEmployee(employee);
        assertEquals(true, result);
    }

    @Test
    @Order (2)
    public void insertEmployeeFail() {
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee = null;
        Boolean result = dao.insertEmployee(employee);
        assertEquals(false, result);
    }

    @Test
    @Order (3)
    public void retrieveAllEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        Employee employee1 = new Employee(102, "TestInsertEmployee2", BigDecimal.valueOf(1234.56));
        Employee employee2 = new Employee(103, "TestInsertEmployee3", BigDecimal.valueOf(789.10));
        dao.insertEmployee(employee1);
        dao.insertEmployee(employee2);

        List<Employee> employeeList = dao.retrieveAllEmployee();
        assertEquals(3, employeeList.size());
    }

    @Test
    @Order (4)
    public void retrieveEmployeeByID() {
        EmployeeDAO dao = new EmployeeDAO();
        Optional<Employee> emp = dao.retrieveEmployeeByID(102);
        assertEquals(102, emp.get().getId());
    }

    @Test
    @Order (5)
    public void deleteEmployeeByIDPass() {
        EmployeeDAO dao = new EmployeeDAO();
        Boolean result = dao.deleteEmployeeByID(101);
        assertEquals(true, result);
    }

    @Test
    @Order (6)
    public void deleteEmployeeByIDFail() {
        EmployeeDAO dao = new EmployeeDAO();
        Boolean result = dao.deleteEmployeeByID(110);
        assertEquals(false, result);
    }
}