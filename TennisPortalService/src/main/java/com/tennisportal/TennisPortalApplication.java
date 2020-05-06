package com.tennisportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrixDashboard
@EnableHystrix
@Configuration
@EnableSwagger2
@SpringBootApplication
public class TennisPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisPortalApplication.class, args);
	}
	
	

}
