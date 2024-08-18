package com.example.user_profile_service.converter;

import com.example.user_profile_service.entity.JobSeekerProfile;
import com.example.user_profile_service.dto.JobSeekerProfileDto;
import org.springframework.stereotype.Component;

@Component
public class JobSeekerConverter {

    public JobSeekerProfile convertToEntity(JobSeekerProfileDto dto) {
        JobSeekerProfile entity = new JobSeekerProfile();
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
        return entity;
    }

    public JobSeekerProfileDto convertToDTO(JobSeekerProfile entity) {
        JobSeekerProfileDto dto = new JobSeekerProfileDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setProfilePictureUrl(entity.getProfilePictureUrl());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setGender(entity.getGender());
        dto.setHeadline(entity.getHeadline());
        dto.setCurrentPosition(entity.getCurrentPosition());
        dto.setCompany(entity.getCompany());
        dto.setProfessionalSummary(entity.getProfessionalSummary());
        dto.setResumeUrl(entity.getResumeUrl());
        dto.setSkills(entity.getSkills());
        return dto;
    }
}
