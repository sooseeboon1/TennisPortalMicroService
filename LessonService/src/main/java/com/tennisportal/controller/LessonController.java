package com.tennisportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennisportal.model.Lessons;
import com.tennisportal.service.LessonService;

@RestController
@RequestMapping("/tennisportal")
public class LessonController {

	@Autowired
	LessonService lessonService;
	
	@GetMapping("/lessons")
	public Lessons getLessons() {
		return lessonService.getLessons();
	}
}
