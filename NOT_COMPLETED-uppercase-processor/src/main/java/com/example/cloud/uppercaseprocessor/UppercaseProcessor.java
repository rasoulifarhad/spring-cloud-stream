package com.example.cloud.uppercaseprocessor;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.config.EnableIntegrationManagement;
import org.springframework.integration.http.config.EnableIntegrationGraphController;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableIntegration
@IntegrationComponentScan
@EnableIntegrationManagement
@EnableIntegrationGraphController(allowedOrigins="*") 
@EnableWebFlux
@SpringBootApplication
public class UppercaseProcessor {

	public static void main(String[] args) {
		SpringApplication.run(UppercaseProcessor.class, args);
	}
	
	@Bean
	public Function<String,String> toUpperCase() {
		return (input) -> {
			return input.toUpperCase();
		};
	}
}
