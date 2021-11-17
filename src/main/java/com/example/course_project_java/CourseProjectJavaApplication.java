package com.example.course_project_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class CourseProjectJavaApplication {
	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.ofMegabytes(500));
		factory.setMaxRequestSize(DataSize.ofMegabytes(500));
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseProjectJavaApplication.class, args);
	}
}
