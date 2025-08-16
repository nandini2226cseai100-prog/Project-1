package com.example.annotationsdemo.service;

import com.example.annotationsdemo.strategy.GreetingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DefaultGreetingService implements GreetingService {

	private final GreetingStrategy greetingStrategy;

	public DefaultGreetingService(@Qualifier("formalGreeting") GreetingStrategy greetingStrategy) {
		this.greetingStrategy = greetingStrategy;
	}

	@Override
	public String greetByName(String name) {
		return greetingStrategy.greet(name);
	}
}