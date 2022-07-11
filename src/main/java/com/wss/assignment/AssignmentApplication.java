package com.wss.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
		"com.wss.assignment.services",
		"com.wss.assignment.restserver"
})
@EntityScan({
		"com.wss.assignment.models"
})
@EnableJpaRepositories({
		"com.wss.assignment.repositories"
})
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

}
