package com.devmare.demo.repository;

import com.devmare.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//? @RepositoryRestResource(path = "members")
//? http://localhost:8081/devmare-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
