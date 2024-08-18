package com.example.user_profile_service.converter;

import com.example.user_profile_service.entity.EmployerProfile;
import com.example.user_profile_service.dto.EmployerProfileDto;
import org.springframework.stereotype.Component;

@Component
public class EmployerConverter {

    public EmployerProfile convertToEntity(EmployerProfileDto dto) {
        EmployerProfile entity = new EmployerProfile();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setProfilePictureUrl(dto.getProfilePictureUrl());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setCompanyName(dto.getCompanyName());
        entity.setCompanyDescription(dto.getCompanyDescription());
        entity.setCompanyWebsite(dto.getCompanyWebsite());
        entity.setIndustry(dto.getIndustry());
        entity.setCompanySize(dto.getCompanySize());
        entity.setHeadquarters(dto.getHeadquarters());
        entity.setEstablishedDate(dto.getEstablishedDate());
        entity.setEmployerRole(dto.getEmployerRole());
        entity.setCompanyLogoUrl(dto.getCompanyLogoUrl());
        return entity;
    }

    public EmployerProfileDto convertToDTO(EmployerProfile entity) {
        EmployerProfileDto dto = new EmployerProfileDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setProfilePictureUrl(entity.getProfilePictureUrl());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setGender(entity.getGender());
        dto.setCompanyName(entity.getCompanyName());
        dto.setCompanyDescription(entity.getCompanyDescription());
        dto.setCompanyWebsite(entity.getCompanyWebsite());
        dto.setIndustry(entity.getIndustry());
        dto.setCompanySize(entity.getCompanySize());
        dto.setHeadquarters(entity.getHeadquarters());
        dto.setEstablishedDate(entity.getEstablishedDate());
        dto.setEmployerRole(entity.getEmployerRole());
        dto.setCompanyLogoUrl(entity.getCompanyLogoUrl());
        return dto;
    }

}
