package com.devmare.cruddemo.dao;

import com.devmare.cruddemo.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
