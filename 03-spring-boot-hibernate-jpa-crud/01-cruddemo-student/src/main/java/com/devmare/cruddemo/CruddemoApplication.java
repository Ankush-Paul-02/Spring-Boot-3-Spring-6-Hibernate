package com.devmare.cruddemo;

import com.devmare.cruddemo.dao.StudentDao;
import com.devmare.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            /*
             createStudent(studentDao);
             readStudent(studentDao);
             queryForStudents(studentDao);
             queryForStudentsByLastName(studentDao);
             updateStudent(studentDao);
             deleteStudent(studentDao);
            */
            createStudent(studentDao);
        };
    }

    private void deleteStudent(StudentDao studentDao) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDao.deleteStudent(studentId);
    }

    private void updateStudent(StudentDao studentDao) {
        //! Retrieve student based on id
        int studentId = 1;
        System.out.println("Getting student id: " + studentId);
        Student student =  studentDao.findById(studentId);
        //! Change something
        System.out.println("Updating student...");
        student.setEmail("ankush199@gmail.com");
        //! Update student
        studentDao.updateStudent(student);
        //! Display
        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDao studentDao) {
        //! Get a list of students
        List<Student> studentList = studentDao.findByLastName("Paul");
        //! Display list of students
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDao studentDao) {
        //! Get a list of students
        List<Student> students = studentDao.findAll();
        //! Display list of students
        for (Student student: students) {
            System.out.println(student);
        }
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
        Student student = new Student("Sid", "Mahato", "sid@gmail.com");

        //! Save the student object
        System.out.println("Saving the student...");
        studentDao.saveStudent(student);
        //! Display id of the saved student
        System.out.println("Student saved!");
        System.out.println("Generated id: " + student.getId());
    }
}
