package com.tennisportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tennisportal.model.UserProfile;
import com.tennisportal.service.UserProfileService;

@RestController
@RequestMapping("tennisportal")
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;
	
	@GetMapping("/userprofile")
	public ResponseEntity<UserProfile> getUserProfile() {
		return userProfileService.getUserProfile();
	}
}
