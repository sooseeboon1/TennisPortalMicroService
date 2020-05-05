package com.tennisportal.service;

import org.springframework.stereotype.Service;

import com.tennisportal.model.Lesson;
import com.tennisportal.model.Lessons;

@Service	
public class LessonService {
	public Lessons getLessons() {
		Lesson l = new Lesson();
		l.setLevel("3.0");
		l.setName("ForeHand Lesson");
		Lessons lessons = new Lessons();
		lessons.getLessons().add(l);
		return lessons;
	}
}
