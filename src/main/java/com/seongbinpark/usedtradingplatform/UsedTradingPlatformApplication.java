package com.seongbinpark.usedtradingplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UsedTradingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsedTradingPlatformApplication.class, args);
	}

}
