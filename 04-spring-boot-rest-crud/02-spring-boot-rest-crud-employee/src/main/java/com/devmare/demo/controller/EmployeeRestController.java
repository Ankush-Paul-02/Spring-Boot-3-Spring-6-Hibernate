package com.devmare.demo.controller;

import com.devmare.demo.entity.Employee;
import com.devmare.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //! Inject employee service (using constructor injection)
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //! expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //! Add mapping for GET /employees/{employeeId} - get employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
        return employee;
    }

    //! Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        //? Also, just in case they pass an id in JSON ... set id to 0
        //? This is to force a save of new Item ... instead of update
        newEmployee.setId(0);
        return employeeService.saveEmployee(newEmployee);
    }

    //! Add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee currentEmployee) {
        return employeeService.saveEmployee(currentEmployee);
    }

    //! Add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("User not found with id: " + employeeId);
        }
        employeeService.deleteEmployeeById(employeeId);
    }
}
