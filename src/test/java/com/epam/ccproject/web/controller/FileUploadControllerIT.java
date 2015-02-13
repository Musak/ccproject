package com.epam.ccproject.web.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.ccproject.WebappContextConfiguration;
import com.epam.ccproject.web.service.FileProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebappContextConfiguration.class })
public class FileUploadControllerIT {

	@Autowired
	private FileUploadController fileUploadController;

	@Autowired
	private WebApplicationContext wac;

	private MockMultipartFile mockMultipartFile;
	@Mock
	private FileProcessor fileProcessor;
	@Mock
	private RedirectAttributes redirectAttributes;
	
	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = webAppContextSetup(wac).build();
		mockMultipartFile = new MockMultipartFile("myfile.csv",
				"firstName,LastName,Department,Salary".getBytes());
		
	}

	@Test
	public void shouldBeAutowired() {
		assertNotNull(fileUploadController);
	}

	@Test
	public void shouldReturnRedirectStatus() throws Exception {
		Mockito.when(fileProcessor.process(mockMultipartFile)).thenReturn(true);
		
		mockMvc.perform(
				MockMvcRequestBuilders.fileUpload("/").file(mockMultipartFile))
				.andExpect(status().is3xxRedirection());
	}

}
