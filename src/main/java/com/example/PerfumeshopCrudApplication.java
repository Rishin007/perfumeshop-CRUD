package com.example;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "SPRING BOOT REST API DOCUMENTATION",
				description = "Basic CRUD Operation using Collection and Exception",
				version = "v1.0",
				contact = @Contact(
						name = "Rishin Dutta",
						email = "rishin.dutta2004@gmal.com",
						url = "https://github.com/Rishin007"
				)
		),
				externalDocs=@ExternalDocumentation(
						description = "SPRING BOOT User Management Quick Start Guide",
						url = "https://spring.io/quickstart"
				)
		)

@SpringBootApplication
public class PerfumeshopCrudApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PerfumeshopCrudApplication.class, args);
	}

}
