package com.example.user_profile_service.service;

import com.example.user_profile_service.converter.JobSeekerConverter;
import com.example.user_profile_service.dto.JobSeekerProfileDto;
import com.example.user_profile_service.entity.JobSeekerProfile;
import com.example.user_profile_service.repository.JobSeekerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobSeekerProfileService {

    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Autowired
    private JobSeekerConverter converter;

    public JobSeekerProfileDto createJobSeekerProfile(JobSeekerProfileDto jobSeekerProfileDTO) {
        JobSeekerProfile jobSeekerProfile = converter.convertToEntity(jobSeekerProfileDTO);
        JobSeekerProfile savedProfile = jobSeekerProfileRepository.save(jobSeekerProfile);
        return converter.convertToDTO(savedProfile);
    }

    public JobSeekerProfileDto updateJobSeekerProfile(Long id, JobSeekerProfileDto jobSeekerProfileDTO) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Seeker profile not found"));

        // Update fields using DTO
        updateEntityWithDTO(jobSeekerProfile, jobSeekerProfileDTO);
        JobSeekerProfile updatedProfile = jobSeekerProfileRepository.save(jobSeekerProfile);
        return converter.convertToDTO(updatedProfile);
    }

    public JobSeekerProfileDto getJobSeekerProfile(Long id) {
        JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Seeker profile not found"));
        return converter.convertToDTO(jobSeekerProfile);
    }

    public List<JobSeekerProfileDto> getAllJobSeekerProfiles() {
        return jobSeekerProfileRepository.findAll().stream()
                .map((entity) -> converter.convertToDTO(entity))
                .collect(Collectors.toList());
    }

    public void deleteJobSeekerProfile(Long id) {
        jobSeekerProfileRepository.deleteById(id);
    }

    private void updateEntityWithDTO(JobSeekerProfile entity, JobSeekerProfileDto dto) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setProfilePictureUrl(dto.getProfilePictureUrl());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setHeadline(dto.getHeadline());
        entity.setCurrentPosition(dto.getCurrentPosition());
        entity.setCompany(dto.getCompany());
        entity.setProfessionalSummary(dto.getProfessionalSummary());
        entity.setResumeUrl(dto.getResumeUrl());
        entity.setSkills(dto.getSkills());
    }
}
