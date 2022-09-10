package com.uninote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UninoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UninoteApplication.class, args);
	}

}
