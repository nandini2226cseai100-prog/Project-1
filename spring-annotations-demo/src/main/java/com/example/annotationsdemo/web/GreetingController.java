package com.example.annotationsdemo.web;

import com.example.annotationsdemo.service.GreetingService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
@Validated
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping("/{name}")
	public String greetPath(@PathVariable("name") String name) {
		return greetingService.greetByName(name);
	}

	@GetMapping
	public String greetQuery(@RequestParam("name") @NotBlank String name) {
		return greetingService.greetByName(name);
	}
}