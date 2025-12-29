package com.trust.trustwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trust.trustwebsite.model.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
