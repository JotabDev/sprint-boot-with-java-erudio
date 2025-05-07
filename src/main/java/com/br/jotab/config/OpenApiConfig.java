package com.br.jotab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPi() {
		return new OpenAPI()
				.info(new Info()
						.title("Rest API Java 21 And Spring Boot 3.0.0")
						.version("v1")
						.description("Descruption In API RestFull")
						.termsOfService("https://exampleTermService.com.br")
						.license( 
								new License()
								.name("Apache 2.0")
								.url("https://www.exampleLicense.com.br")
								)
						);
	}
}
