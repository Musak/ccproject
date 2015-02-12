package com.epam.ccproject.aop;

import java.io.File;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
public class Sky {

	private static final Logger logger = LoggerFactory.getLogger("controller");

	@Pointcut("execution(* com.epam.ccproject.web.service.RandomFileNameGenerator.getFile())")
	public void performance() {
	}

	@AfterReturning(value = "performance()", returning = "returnValue")
	public void println(File returnValue) {
		logger.info("File Saved: " + returnValue.getAbsolutePath());
	}

}
