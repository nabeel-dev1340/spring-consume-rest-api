package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		List<Todo> todos = getTodos();
		for (Todo todo : todos) {
			log.info(todo.toString());
		}
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static List<Todo> getTodos() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Todo[]> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos", Todo[].class);
		Todo[] todos = response.getBody();
		assert todos != null;
		return Arrays.asList(todos);
	}

}
