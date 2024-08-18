package com.example.user_profile_service.controller;

import com.example.user_profile_service.dto.EmployerProfileDto;
import com.example.user_profile_service.service.EmployerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employer-profiles")
public class EmployerProfileController {

    @Autowired
    private EmployerProfileService employerProfileService;

    @PostMapping
    public EmployerProfileDto createEmployerProfile(@RequestBody EmployerProfileDto employerProfileDTO) {
        return employerProfileService.createEmployerProfile(employerProfileDTO);
    }

    @PutMapping("/{id}")
    public EmployerProfileDto updateEmployerProfile(@PathVariable Long id, @RequestBody EmployerProfileDto employerProfileDTO) {
        return employerProfileService.updateEmployerProfile(id, employerProfileDTO);
    }

    @GetMapping("/{id}")
    public EmployerProfileDto getEmployerProfile(@PathVariable Long id) {
        return employerProfileService.getEmployerProfile(id);
    }

    @GetMapping
    public List<EmployerProfileDto> getAllEmployerProfiles() {
        return employerProfileService.getAllEmployerProfiles();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployerProfile(@PathVariable Long id) {
        employerProfileService.deleteEmployerProfile(id);
    }
}
