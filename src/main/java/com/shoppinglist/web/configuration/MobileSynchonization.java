package com.shoppinglist.web.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(value = "synchronize", havingValue = "true")
public class MobileSynchonization {
	
	@Scheduled(initialDelay = 1000L, fixedDelayString = "${synchronizeInterval}")
	void sync() {
		//TO DO
	}

}
