package com.jun.toyproject.invite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class InviteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InviteApplication.class, args);
	}

}
