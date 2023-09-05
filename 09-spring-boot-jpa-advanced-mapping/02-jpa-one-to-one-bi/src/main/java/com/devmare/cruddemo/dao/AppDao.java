package com.devmare.cruddemo.dao;

import com.devmare.cruddemo.entity.Instructor;
import com.devmare.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
