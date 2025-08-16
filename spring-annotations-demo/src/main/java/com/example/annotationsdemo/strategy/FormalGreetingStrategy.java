package com.example.annotationsdemo.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("formalGreeting")
public class FormalGreetingStrategy implements GreetingStrategy {
	@Override
	public String greet(String name) {
		return "Good day, " + name + ".";
	}
}