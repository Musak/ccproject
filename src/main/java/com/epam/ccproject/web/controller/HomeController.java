package com.epam.ccproject.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET, 
			produces=MediaType.TEXT_HTML_VALUE)
	public String getHomepage() {
		return "home";
	}

}
