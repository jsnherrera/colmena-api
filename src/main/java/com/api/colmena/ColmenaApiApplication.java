package com.api.colmena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.api.colmena")
@EnableSwagger2
public class ColmenaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColmenaApiApplication.class, args);
	}

}
