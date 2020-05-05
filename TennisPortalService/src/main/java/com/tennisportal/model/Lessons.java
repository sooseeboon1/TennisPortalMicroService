package com.tennisportal.model;

import java.util.ArrayList;
import java.util.List;

public class Lessons {
	private List<Lesson> lessons = new ArrayList<Lesson>();

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
}
