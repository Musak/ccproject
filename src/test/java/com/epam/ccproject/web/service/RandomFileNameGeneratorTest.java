package com.epam.ccproject.web.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.ccproject.web.service.RandomFileNameGenerator;
import com.epam.ccproject.web.service.RandomIdentifierGenerator;

public class RandomFileNameGeneratorTest {
 
	private static final String TMP_DIR = "tmpdir";
	private static final String ROOT_DIR = "rootdirr";
	private static final String FILE_NAME = "FileName";
	
	@Mock
	private RandomIdentifierGenerator generator;
	private RandomFileNameGenerator fileNameGenerator;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		fileNameGenerator = new RandomFileNameGenerator(generator);
	}
	
	@Test
	public void shouldReturnFileWithCorrectName() {
		fileNameGenerator.setRootPath(ROOT_DIR);
		fileNameGenerator.setTempFolderName(TMP_DIR);
		when(generator.getRandomIdentifier()).thenReturn(FILE_NAME);
		
		File file = fileNameGenerator.getFile();

		assertEquals(file.getName(), FILE_NAME + ".csv");
	} 
}
