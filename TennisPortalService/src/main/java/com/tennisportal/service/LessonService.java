package com.tennisportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tennisportal.model.Lesson;
import com.tennisportal.model.Lessons;

@Service
public class LessonService {
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Autowired
	private RestTemplate restTemplate;	
	
	// threadPoolKey is used for bulkhead design pattern. 
	@HystrixCommand(fallbackMethod = "getLessonsFallBack", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	}, threadPoolKey = "getLessonsThreadPool")
	public ResponseEntity<Lessons> getLessons() {
		 ResponseEntity<Lessons> responseEntity = restTemplate.getForEntity("http://lesson-service/tennisportal/lessons", Lessons.class);
		 return responseEntity;
	}
	
	// Fall back for getLessons()
	private  ResponseEntity<Lessons> getLessonsFallBack() {
		Lessons lessons = new Lessons();
		Lesson l = new Lesson();
		l.setName("dummp");
		l.setLevel("1");
		lessons.getLessons().add(l);
		return ResponseEntity.ok(lessons);
	}
	
	// Reactive way.
	public ResponseEntity<String> getLessons2() {
		String body = webClientBuilder.build()
				.get() // GET method
				.uri("http://tennis-lesson/tennisportal/lessons")
				.retrieve() // Retrieve the result
				.bodyToMono(String.class) // Convert to result when get it
				.block(); // Wait
		return ResponseEntity.ok(body);
	}
}
