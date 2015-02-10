package com.epam.ccproject.web.controller;

import static  org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.epam.ccproject.WebappContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebappContextConfiguration.class)
@WebAppConfiguration
public class HomeControllerIT {

	@Autowired
	private HomeController homecontroller;
	
	@Test
	public void homeChouldNotBeNull() {
		assertNotNull(homecontroller);
	}
}
