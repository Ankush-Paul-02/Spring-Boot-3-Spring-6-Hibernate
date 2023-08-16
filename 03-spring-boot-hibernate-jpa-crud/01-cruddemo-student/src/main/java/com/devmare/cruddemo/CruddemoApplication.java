package com.devmare.cruddemo;

import com.devmare.cruddemo.dao.StudentDao;
import com.devmare.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            // createStudent(studentDao);
            readStudent(studentDao);
        };
    }

    private void readStudent(StudentDao studentDao) {
        //! Create a student object
        System.out.println("Creating new Student object");
        Student student = new Student("Sid", "Mahato", "sid@gmail.com");
        //! Save the student
        System.out.println("Saving the student...");
        studentDao.saveStudent(student);
        //! Display id of the saved student
        System.out.println("Student id: " + student.getId());
        //! Retrieve student based on the id
        System.out.println("Retrieve student with id: " + student.getId());
        Student student1 = studentDao.findById(student.getId());
        //! Display student
        System.out.println("Found the student: " + student1);
    }

    private void createStudent(StudentDao studentDao) {
        //! Create the student object
        System.out.println("Creating new Student object...");
        Student student = new Student("Deepon", "Das", "deepon@gmail.com");

        //! Save the student object
        System.out.println("Saving the student...");
        studentDao.saveStudent(student);
        //! Display id of the saved student
        System.out.println("Student saved!");
        System.out.println("Generated id: " + student.getId());
    }
}
