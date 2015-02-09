package com.epam.ccproject.web.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HomeControllerTest {
	private HomeController homeController;

	@Before
	public void init() {
		homeController = new HomeController();
	}

	@Test
	public void shouldReturnHomepageTilesDefinitionName() {
		String shouldReturnThisHomepageValue = "home";
		
		String homepage = homeController.getHomepage();

		assertEquals(homepage, shouldReturnThisHomepageValue);
	}
	
}
