package com.example.annotationsdemo;

import com.example.annotationsdemo.config.GreetingProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GreetingProperties.class)
public class AnnotationsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationsDemoApplication.class, args);
    }
}