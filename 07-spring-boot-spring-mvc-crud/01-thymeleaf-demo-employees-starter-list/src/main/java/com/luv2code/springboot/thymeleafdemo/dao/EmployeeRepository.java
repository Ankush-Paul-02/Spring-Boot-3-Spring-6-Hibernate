package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//? that's it ... no need to write any code LOL!

    //! Add a method to sort employee by last name

    /**
     * Spring data jpa parse the method name, the look for specific format and
     * pattern, and they'll create the appropriate query for us behind the screen
     */
	public List<Employee> findAllByOrderByLastNameAsc();
}
