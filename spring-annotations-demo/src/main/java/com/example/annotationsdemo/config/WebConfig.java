package com.example.annotationsdemo.config;

import com.example.annotationsdemo.strategy.GreetingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

	@Bean
	@ConditionalOnProperty(prefix = "app.greeting", name = "uppercase", havingValue = "true")
	public GreetingStrategy uppercaseGreetingStrategy(GreetingProperties properties) {
		log.info("Registering uppercaseGreetingStrategy bean due to property app.greeting.uppercase=true");
		return name -> (properties.getMessage() + ", " + name + properties.getSuffix()).toUpperCase();
	}
}