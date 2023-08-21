package com.devmare.demo.dao;

import com.devmare.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //! Define field for entity manager
    private EntityManager entityManager;
    //! Set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        //! Create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);
        //! Execute query and get result list
        return query.getResultList();
    }
}
