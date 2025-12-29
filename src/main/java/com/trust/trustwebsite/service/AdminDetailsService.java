package com.trust.trustwebsite.service;

import com.trust.trustwebsite.model.Admin;
import com.trust.trustwebsite.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service   // ⭐ VERY IMPORTANT
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found"));

        return User.withUsername(admin.getUsername())
                .password(admin.getPassword())
                .roles("ADMIN")   // ✅ ONLY ADMIN
                .build();
    }
}
