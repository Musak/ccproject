package com.epam.ccproject.web.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.epam.ccproject.web.service.RandomIdentifierGenerator;

public class RandomIdentifierGeneratorTest {

	private RandomIdentifierGenerator generator;
	
	@Before
	public void init() {
		generator = new RandomIdentifierGenerator();
	}
	
	@Test
	public void shouldHaveLenghtMoreEqualsThan5Characters() {
		String identifier = generator.getRandomIdentifier();
		
		assertTrue(identifier.length()>=5);
	}
	
	@Test
	public void shouldHaveLenghtLessThan10Characters() {
		String identifier = generator.getRandomIdentifier();
		
		assertTrue(identifier.length()<10);
	}
	
	@Test
	public void shouldReturnDifferentResultForTwogeneratedIdentifier() {
		String identifier1 = generator.getRandomIdentifier();
		String identifier2 = generator.getRandomIdentifier();
		
		assertNotEquals(identifier1, identifier2);
	}
}
