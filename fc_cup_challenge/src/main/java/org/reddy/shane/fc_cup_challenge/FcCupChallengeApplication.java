package org.reddy.shane.fc_cup_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FcCupChallengeApplication {

	/**
	 * Class for JAR package usage.
	 * */
	public static void main(String[] args) {
		SpringApplication.run(FcCupChallengeApplication.class, args);
	}

}