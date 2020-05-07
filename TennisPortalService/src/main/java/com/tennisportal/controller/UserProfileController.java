package com.tennisportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennisportal.model.UserProfile;
import com.tennisportal.service.UserProfileService;

@RestController
@RequestMapping("tennisportal")
@RefreshScope
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;
	
	@Value("${foo.name}")
	String value;
	
	// This get value from config server.
	@GetMapping("get_config")
	public String getConfigFromConfigServer() {
		return "Return value is " + value;
	}
	
	@GetMapping("/userprofile")
	public ResponseEntity<UserProfile> getUserProfile() {
		return userProfileService.getUserProfile();
	}
}
