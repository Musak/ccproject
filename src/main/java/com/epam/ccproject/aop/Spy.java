package com.epam.ccproject.aop;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
public class Spy {

	private static final Logger logger = LoggerFactory.getLogger("main");
	private static final AtomicInteger count = new AtomicInteger(0);

	@Pointcut("execution(public * *(..)) && (@annotation(org.springframework.web.bind.annotation.RequestMapping) "
			+ "|| @annotation(org.springframework.web.bind.annotation.ModelAttribute))")
	public void requestMapping() {}
	
	@Before(value = "requestMapping()")
	public void methodTracker(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.debug("@" + methodName + " counter: "
				+ (count.getAndIncrement()));
	}

	@Around("requestMapping()")
	public Object watchPerformance(ProceedingJoinPoint joinPoint)
			throws Throwable {
		String methodName = joinPoint.getSignature().toShortString();
		logger.debug("@" + methodName + " START");
		
		long start = System.nanoTime();
		Object returnVal = joinPoint.proceed();
		long end = System.nanoTime();
		logger.debug("@" + methodName + " END");
		
		Double diff = (double) ((double) (end - start) / 1000000000d);
		logger.debug("@" + methodName + " Execution time: "
				+ diff.doubleValue() + " seconds" + System.lineSeparator());
		return returnVal;
	}

	@AfterReturning(value = "execution(* com.epam.ccproject.web.service.RandomFileNameGenerator.getFile())", returning = "returnValue")
	public void println(File returnValue) {
		logger.info("File Saved: " + returnValue.getAbsolutePath());
	}

}
