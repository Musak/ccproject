package com.epam.ccproject.web.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

public class SimpleFileProcessorTest {

	@Mock
	private FileNameGenerator fileNameGenerator;
	
	@Mock
	private MultipartFile multipartFile;
	
	private SimpleFileProcessor processor;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		processor = new SimpleFileProcessor(fileNameGenerator);
	}
	
	@Test
	public void shouldCallMultipartFileTransferAtLeastOnce() throws IllegalStateException, IOException {
		File myFile = new File("pathToFile.csv");
		when(fileNameGenerator.getFile()).thenReturn(myFile);
		
		processor.process(multipartFile);
		
		verify(multipartFile).transferTo(myFile);
	}
	
	@Test
	public void shouldReturnErrorMessageOnFileTransferException() throws IllegalStateException, IOException {
		File myFile = new File("pathToFile.csv");
		when(fileNameGenerator.getFile()).thenReturn(myFile);
		doThrow(IOException.class).when(multipartFile).transferTo(myFile);
		
		Boolean answer = processor.process(multipartFile);
		
		assertFalse(answer);
	}
	
	@Test
	public void shouldReturnsuccessfullyMessage() {
		File myFile = new File("pathToFile.csv");
		when(fileNameGenerator.getFile()).thenReturn(myFile);
		
		Boolean answer = processor.process(multipartFile);
		
		assertTrue(answer);
	}
	
	
}
