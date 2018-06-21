package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.demo.models.entities")
public class AcmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmProjectApplication.class, args);
	}
}
