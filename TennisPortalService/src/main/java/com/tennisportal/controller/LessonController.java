package com.tennisportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tennisportal.model.Lessons;
import com.tennisportal.service.LessonService;

@RestController
@RequestMapping("tennisportal")
public class LessonController {
	
	@Autowired
	LessonService lessonService;
	
	@GetMapping("lessons")
	public ResponseEntity<Lessons> getLessons() {
		 ResponseEntity<Lessons> responseEntity = lessonService.getLessons();
		 return responseEntity;
	}
	
	// Reactive way.
	@GetMapping("lessons2")
	public ResponseEntity<String> getLessons2() {
		ResponseEntity<String> result  =lessonService.getLessons2();
		return result;
	}
}
