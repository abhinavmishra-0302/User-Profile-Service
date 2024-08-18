package com.example.user_profile_service.repository;

import com.example.user_profile_service.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Long> {
    JobSeekerProfile findByUsername(String username);
}
