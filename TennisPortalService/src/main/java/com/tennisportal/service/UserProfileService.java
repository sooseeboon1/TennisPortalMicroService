package com.tennisportal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tennisportal.model.Lessons;
import com.tennisportal.model.Players;
import com.tennisportal.model.UserProfile;

@Service
public class UserProfileService {
	Logger logger = LoggerFactory.getLogger(UserProfileService.class);
	
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
//		logger.debug("Response from lesson service");
//		lessons.getBody().getLessons().forEach( lesson -> {
//			logger.debug(lesson.getName());
//		});
		
//		logger.debug("Response from player service");
		ResponseEntity<Players> players = playerService.getPlayers();	
//		lessons.getBody().getLessons().forEach( player -> {
//			logger.debug(player.getName());
//		});
		
		UserProfile userProfile = new UserProfile();
		userProfile.setLessons(lessons.getBody());
		userProfile.setOpponents(players.getBody());
		userProfile.setName("SeeBoonSoo");
		return ResponseEntity.ok(userProfile);
	}
}
