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
            // createInstructor(appDao);
            // findInstructorById(appDao);
            // deleteInstructorById(appDao);
            // findInstructorDetailById(appDao);
            deleteInstructorDetailByrId(appDao);
        };
    }

    private void deleteInstructorDetailByrId(AppDao appDao) {
        int id = 6;
        System.out.println("Deleting instructor detail of id: " + id);
        appDao.deleteInstructorDetailById(id);
        System.out.println("Deleted...");
    }

    private void findInstructorDetailById(AppDao appDao) {
        //! GEt the instructor details object
        int id = 4;
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
        //! Print the details
        System.out.println("Instructor Details: ");
        System.out.println(instructorDetail);
        //! Print the associated instructor
        System.out.println("The associated instructor: " + instructorDetail.getInstructor());
    }

    private void deleteInstructorById(AppDao appDao) {
        int id = 2;
        System.out.println("Deleting instructor of id: " + id);
        appDao.deleteInstructorById(id);
        System.out.println("Deleted!");
    }

    private void findInstructorById(AppDao appDao) {
        int id = 2;
        System.out.println("Searching instructor of id: " + id);
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println(instructor);
        System.out.println("The associated instructor details: ");
        System.out.println(instructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {
        //! Create the instructor
        Instructor instructor = new Instructor(
                "Deepon", "Das", "deepon@gmail.com"
        );
        //! Create instructor details
        InstructorDetail instructorDetail = new InstructorDetail(
                "Devmare", "Reels"
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
