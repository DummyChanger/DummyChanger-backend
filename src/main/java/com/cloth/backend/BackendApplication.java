package com.cloth.backend;

import com.cloth.backend.Services.UserService;
import com.cloth.backend.model.Role;
import com.cloth.backend.model.User;
import com.cloth.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(new ArrayList<Role>(), null, "lakshan", "lakshanamal100@gmail.com", "password"));
            userService.saveUser(new User(new ArrayList<Role>(), null, "kavi", "kavi@gmail.com", "password"));
            userService.saveUser(new User(new ArrayList<Role>(), null, "devi", "devi@gmail.com", "password"));

            userService.addRoleToUser("lakshanamal100@gmail.com", "ROLE_USER");
            userService.addRoleToUser("kavi@gmail.com", "ROLE_ADMIN");
        };
    }

}
