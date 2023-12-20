package com.epa.inventarioLog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication

public class InventarioLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioLogApplication.class, args);
	}

}
