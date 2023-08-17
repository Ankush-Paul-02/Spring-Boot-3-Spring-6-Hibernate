package com.devmare.cruddemo.dao;

import com.devmare.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
