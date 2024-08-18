package com.example.user_profile_service.service;

import com.example.user_profile_service.converter.EmployerConverter;
import com.example.user_profile_service.dto.EmployerProfileDto;
import com.example.user_profile_service.entity.EmployerProfile;
import com.example.user_profile_service.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerProfileService {

    @Autowired
    private EmployerRepository employerProfileRepository;

    @Autowired
    private EmployerConverter converter;

    public EmployerProfileDto createEmployerProfile(EmployerProfileDto employerProfileDTO) {
        EmployerProfile employerProfile = converter.convertToEntity(employerProfileDTO);
        EmployerProfile savedProfile = employerProfileRepository.save(employerProfile);
        return converter.convertToDTO(savedProfile);
    }

    public EmployerProfileDto updateEmployerProfile(Long id, EmployerProfileDto employerProfileDTO) {
        EmployerProfile employerProfile = employerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer profile not found"));

        // Update fields using DTO
        updateEntityWithDTO(employerProfile, employerProfileDTO);
        EmployerProfile updatedProfile = employerProfileRepository.save(employerProfile);
        return converter.convertToDTO(updatedProfile);
    }

    public EmployerProfileDto getEmployerProfile(Long id) {
        EmployerProfile employerProfile = employerProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employer profile not found"));
        return converter.convertToDTO(employerProfile);
    }

    public List<EmployerProfileDto> getAllEmployerProfiles() {
        return employerProfileRepository.findAll().stream()
                .map((entity) -> converter.convertToDTO(entity))
                .collect(Collectors.toList());
    }

    public void deleteEmployerProfile(Long id) {
        employerProfileRepository.deleteById(id);
    }

    private void updateEntityWithDTO(EmployerProfile entity, EmployerProfileDto dto) {
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
    }
}

