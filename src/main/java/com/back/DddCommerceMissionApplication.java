package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DddCommerceMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DddCommerceMissionApplication.class, args);
	}

}
