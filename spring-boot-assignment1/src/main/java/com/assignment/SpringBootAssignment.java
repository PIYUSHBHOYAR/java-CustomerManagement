package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

@SpringBootApplication
public class SpringBootAssignment {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment.class, args);
	}

	@Bean
	public Gson gson()
	{
		return new Gson();
	}
}
