package com.abaco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbacoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbacoApplication.class, args);

//		ConfigurableApplicationContext context = null;
//		try {
//			context = SpringApplication.run(AbacoApplication.class, args);
//		} finally {
//			if (context != null && context.isRunning()) {
//				context.close();
//			}
//		}

	}

}
