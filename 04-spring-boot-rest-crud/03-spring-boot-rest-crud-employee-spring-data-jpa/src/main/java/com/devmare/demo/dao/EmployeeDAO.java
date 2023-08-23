package com.devmare.demo.dao;

import com.devmare.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
