package com.example.user_profile_service.controller;

import com.example.user_profile_service.dto.JobSeekerProfileDto;
import com.example.user_profile_service.service.JobSeekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job-seeker-profiles")
public class JobSeekerProfileController {

    @Autowired
    private JobSeekerProfileService jobSeekerProfileService;

    @PostMapping
    public JobSeekerProfileDto createJobSeekerProfile(@RequestBody JobSeekerProfileDto jobSeekerProfileDTO) {
        return jobSeekerProfileService.createJobSeekerProfile(jobSeekerProfileDTO);
    }

    @PutMapping("/{id}")
    public JobSeekerProfileDto updateJobSeekerProfile(@PathVariable Long id, @RequestBody JobSeekerProfileDto jobSeekerProfileDTO) {
        return jobSeekerProfileService.updateJobSeekerProfile(id, jobSeekerProfileDTO);
    }

    @GetMapping("/{id}")
    public JobSeekerProfileDto getJobSeekerProfile(@PathVariable Long id) {
        return jobSeekerProfileService.getJobSeekerProfile(id);
    }

    @GetMapping
    public List<JobSeekerProfileDto> getAllJobSeekerProfiles() {
        return jobSeekerProfileService.getAllJobSeekerProfiles();
    }

    @DeleteMapping("/{id}")
    public void deleteJobSeekerProfile(@PathVariable Long id) {
        jobSeekerProfileService.deleteJobSeekerProfile(id);
    }
}
