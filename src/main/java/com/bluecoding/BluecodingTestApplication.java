package com.bluecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BluecodingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluecodingTestApplication.class, args);
	}

}
