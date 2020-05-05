package com.tennisportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tennisportal.model.Lessons;
import com.tennisportal.model.Players;
import com.tennisportal.model.UserProfile;

@Service
public class UserProfileService {
		
	
	@Autowired
	private LessonService lessonService;
	
	@Autowired
	private PlayerService playerService;
	
	public ResponseEntity<Lessons> getLessons() {
		return lessonService.getLessons();
	}
	
	public Players getOpponents() {
		return null;
	}
	
	public  ResponseEntity<UserProfile> getUserProfile() {
		ResponseEntity<Lessons> lessons = lessonService.getLessons();
		ResponseEntity<Players> players = playerService.getPlayers();				
		UserProfile userProfile = new UserProfile();
		userProfile.setLessons(lessons.getBody());
		userProfile.setOpponents(players.getBody());
		userProfile.setName("SeeBoonSoo");
		return ResponseEntity.ok(userProfile);
	}
}
