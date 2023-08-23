package com.devmare.demo.service;

import com.devmare.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
