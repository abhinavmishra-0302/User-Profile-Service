package com.example.user_profile_service.controller;

import com.example.user_profile_service.models.UserProfile;
import com.example.user_profile_service.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping
    private UserProfile createProfile(@RequestBody UserProfile userProfile){
        return userProfileService.createUserProfile(userProfile);
    }

    @PutMapping("/{id}")
    private UserProfile updateProfile(@PathVariable Long id, @RequestBody UserProfile userProfile){
        return userProfileService.updateUserProfile(id, userProfile);
    }

    @GetMapping("/{id}")
    public UserProfile getUserProfile(@PathVariable Long id){
        return userProfileService.getUserProfile(id);
    }

    @GetMapping
    public List<UserProfile> getAllProfiles(){
        return userProfileService.getAllProfiles();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userProfileService.deleteUserById(id);
    }
}
