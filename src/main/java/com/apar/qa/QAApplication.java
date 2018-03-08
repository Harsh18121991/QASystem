package com.apar.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
//@EnableCaching
public class QAApplication {

	public static void main(String[] args) {
		SpringApplication.run(QAApplication.class, args);
	}
}
