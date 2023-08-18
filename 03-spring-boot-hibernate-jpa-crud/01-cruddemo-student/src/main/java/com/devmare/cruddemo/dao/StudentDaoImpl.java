package com.devmare.cruddemo.dao;

import com.devmare.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    //! Define field for entity manager
    private EntityManager entityManager;
    //! Using entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //! Create query
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
        //! Return query result
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //! Create query
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        //! Set query parameter
        query.setParameter("theData", lastName);
        //! Return query result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
