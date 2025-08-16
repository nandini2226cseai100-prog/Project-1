package com.example.annotationsdemo.strategy;

import com.example.annotationsdemo.config.GreetingProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DefaultGreetingStrategy implements GreetingStrategy {

	private final GreetingProperties properties;

	public DefaultGreetingStrategy(GreetingProperties properties) {
		this.properties = properties;
	}

	@Override
	public String greet(String name) {
		return properties.getMessage() + ", " + name + properties.getSuffix();
	}
}