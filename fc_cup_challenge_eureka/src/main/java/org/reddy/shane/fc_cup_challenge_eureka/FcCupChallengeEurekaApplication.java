package org.reddy.shane.fc_cup_challenge_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FcCupChallengeEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FcCupChallengeEurekaApplication.class, args);
	}
}