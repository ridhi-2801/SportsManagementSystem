package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ParticipationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParticipationApplication.class, args);
	}

}
