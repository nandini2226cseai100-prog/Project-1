package com.example.annotationsdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.example.annotationsdemo.service.*.*(..))")
	public void logBeforeServiceMethods(JoinPoint joinPoint) {
		log.info("Entering {} with args {}", joinPoint.getSignature(), joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "execution(* com.example.annotationsdemo.service.*.*(..))", returning = "result")
	public void logAfterServiceMethods(JoinPoint joinPoint, Object result) {
		log.info("Exiting {} with result {}", joinPoint.getSignature(), result);
	}
}