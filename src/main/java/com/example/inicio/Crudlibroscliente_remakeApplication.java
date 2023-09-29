package com.example.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

/**
 * Mapeamos la aplcacion y la iniciamos
 */
@SpringBootApplication(scanBasePackages = { "com.example.controller", "com.example.services" })
public class Crudlibroscliente_remakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Crudlibroscliente_remakeApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
