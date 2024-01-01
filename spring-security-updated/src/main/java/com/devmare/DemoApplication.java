package com.devmare;

import com.devmare.model.Role;
import com.devmare.model.User;
import com.devmare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User adminAccount = userRepository.findByRole(Role.ADMIN);

        if (adminAccount == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setUsername("Advayam Admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);
        }
    }
}
