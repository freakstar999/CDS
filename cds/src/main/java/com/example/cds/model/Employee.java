package com.example.cds.model;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class Employee {

    @CsvBindByName
    private int id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private BigDecimal salary;

    public Employee() {

    }

    /*public Employee(@JsonProperty("id") int id,
                    @JsonProperty("name")String name,
                    @JsonProperty("salary") BigDecimal salary) {*/
    public Employee(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
