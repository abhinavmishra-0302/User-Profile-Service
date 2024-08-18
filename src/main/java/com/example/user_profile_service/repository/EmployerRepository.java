package com.example.user_profile_service.repository;

import com.example.user_profile_service.entity.EmployerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<EmployerProfile, Long> {
    EmployerProfile findByUsername(String username);
}
