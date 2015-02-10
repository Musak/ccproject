package com.epam.ccproject.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.ccproject.web.service.FileProcessor;

public class FileUploadControllerTest {

	private FileUploadController fileUploadController;
	
	@Mock 
	private FileProcessor fileProcessor;
	
	@Mock
	private MultipartFile multipartFile;
	
	@Mock
	private RedirectAttributes attributes;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		fileUploadController = new FileUploadController(fileProcessor);
	}

	@Test
	public void shouldReturnRedirectToGetPage() {
		String shouldReturnRedirectUrl = "redirect:/";
		
		String redirectUrl = fileUploadController.uploadFile();
		
		assertEquals(shouldReturnRedirectUrl, redirectUrl);
	}
	
	@Test
	public void shouldCallRedirectAttributesSetter() {
		String RETURN_VALUE = "Uploaded";
		Mockito.when(fileProcessor.process(Mockito.any(MultipartFile.class))).thenReturn(RETURN_VALUE);
		
		fileUploadController.uploader(multipartFile, attributes);
		
		Mockito.verify(attributes).addFlashAttribute(RETURN_VALUE);
	}
	
	@Test 
	public void shouldCallRedirectAttributesWithArgumentCapture() {
		String RETURN_VALUE = "Uploaded";
		ArgumentCaptor<String> redirectAttributesValue = ArgumentCaptor.forClass(String.class);
		Mockito.when(fileProcessor.process(Mockito.any(MultipartFile.class))).thenReturn(RETURN_VALUE);
		
		fileUploadController.uploader(multipartFile,attributes);
		
		Mockito.verify(attributes).addFlashAttribute(redirectAttributesValue.capture());
		assertEquals(RETURN_VALUE, redirectAttributesValue.getValue());
	}
}
