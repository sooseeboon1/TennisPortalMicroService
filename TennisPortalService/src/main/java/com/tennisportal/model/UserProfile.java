package com.tennisportal.model;
import com.tennisportal.model.Lessons;
public class UserProfile {
	
	private String name;
	private Lessons lessons;
	private Players opponents;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Lessons getLessons() {
		return lessons;
	}
	public void setLessons(Lessons lessons) {
		this.lessons = lessons;
	}
	public Players getOpponents() {
		return opponents;
	}
	public void setOpponents(Players opponents) {
		this.opponents = opponents;
	}
}
