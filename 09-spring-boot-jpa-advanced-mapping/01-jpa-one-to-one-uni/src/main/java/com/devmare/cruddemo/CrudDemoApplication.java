package com.devmare.cruddemo;

import com.devmare.cruddemo.dao.AppDao;
import com.devmare.cruddemo.entity.Instructor;
import com.devmare.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
            createInstructor(appDao);
        };
    }

    private void createInstructor(AppDao appDao) {
        //! Create the instructor
        Instructor instructor = new Instructor(
                "Ankush", "Paul", "ankush@gmail.com"
        );
        //! Create instructor details
        InstructorDetail instructorDetail = new InstructorDetail(
                "Devmare", "Cricket"
        );
        //! Associate the objects
        instructor.setInstructorDetail(instructorDetail);
        //! Save the instructor
        //? This will also save the user details object because of CASCADE.ALL
        System.out.println("Saving instructor...");
        System.out.println(instructor);
        appDao.save(instructor);
        System.out.println("Done!");
    }
}
