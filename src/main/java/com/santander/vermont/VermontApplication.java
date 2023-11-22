package com.santander.vermont;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@ComponentScan(basePackages = "com.santander.vermont")
public class VermontApplication {

	public static void main(String[] args) {
		SpringApplication.run(VermontApplication.class, args);
		System.out.println("Users Microservices running!");
	}

    @Bean
    OpenAPI customOpenApi(){
		return new OpenAPI()
				.info(new Info()
				.title("Vermont API REST")
				.version("1.0.0")
				.description("Documentation Springboot 3 with Swagger.")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0")
				.url("http://springdoc.org")));
	}
}
