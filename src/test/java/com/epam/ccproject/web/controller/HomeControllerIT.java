package com.epam.ccproject.web.controller;

import static  org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import com.epam.ccproject.WebappContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=WebappContextConfiguration.class)
public class HomeControllerIT {

	@Autowired
	private HomeController homecontroller;
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void shouldNotBeNull() {
		assertNotNull(homecontroller);
	}
	
	@Test
	public void shouldReturnStatusOk() throws Exception {
		mockMvc.perform(get("/").accept(MediaType.TEXT_HTML)).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAcceptOnlyApplicationHTMLMimeType() throws Exception {
		mockMvc.perform(get("/").accept(MediaType.TEXT_HTML)).andExpect(status().isOk());
		mockMvc.perform(get("/").accept(MediaType.TEXT_PLAIN)).andExpect(status().isNotAcceptable());
		mockMvc.perform(get("/").accept(MediaType.TEXT_XML)).andExpect(status().isNotAcceptable());
		mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotAcceptable());
		mockMvc.perform(get("/").accept(MediaType.APPLICATION_XML)).andExpect(status().isNotAcceptable());
	}
	
	@Test
	public void shouldReturnHomeTilesDefinitionValue() throws Exception {
		mockMvc.perform(get("/").accept(MediaType.TEXT_HTML)).andExpect(content().contentType(MediaType.TEXT_HTML));
	}
}
