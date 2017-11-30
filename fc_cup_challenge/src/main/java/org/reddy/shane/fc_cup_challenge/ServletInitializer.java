package org.reddy.shane.fc_cup_challenge;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Class for WAR package usage.
	 * */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FcCupChallengeApplication.class);
	}

}