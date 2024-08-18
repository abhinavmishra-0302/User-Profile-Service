package com.example.user_profile_service.service;

import com.example.user_profile_service.entity.UserProfile;
import com.example.user_profile_service.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile createUserProfile(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    public UserProfile updateUserProfile(Long id, UserProfile userProfile){
        UserProfile user = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        user.setEmail(userProfile.getEmail());
        user.setPhoneNumber(userProfile.getPhoneNumber());
        user.setProfilePictureUrl(userProfile.getProfilePictureUrl());

        return userProfileRepository.save(user);
    }

    public UserProfile getUserProfile(Long id){
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found"));
    }

    public List<UserProfile> getAllProfiles(){
        return userProfileRepository.findAll();
    }

    public void deleteUserById(Long id){
        userProfileRepository.deleteById(id);
    }
}
