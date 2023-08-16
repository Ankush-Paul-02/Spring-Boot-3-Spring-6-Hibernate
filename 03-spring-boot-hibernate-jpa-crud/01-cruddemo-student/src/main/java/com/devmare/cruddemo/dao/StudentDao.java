package com.devmare.cruddemo.dao;

import com.devmare.cruddemo.entity.Student;

public interface StudentDao {
    void saveStudent(Student student);
    Student findById(Integer id);
}
