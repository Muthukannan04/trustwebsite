package com.trust.trustwebsite.config;

import com.trust.trustwebsite.model.Admin;
import com.trust.trustwebsite.repository.AdminRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner initAdmin(AdminRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {

                Admin admin = new Admin();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");

                repo.save(admin);
                System.out.println("✅ Admin user created successfully");
            }
        };
    }
}
