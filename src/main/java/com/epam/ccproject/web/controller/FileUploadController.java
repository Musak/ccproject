package com.epam.ccproject.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.ccproject.web.service.FileProcessor;

@Controller
public class FileUploadController {

	private FileProcessor fileProcessor;
	
	@Autowired
	public FileUploadController(FileProcessor fileProcessor) {
		this.fileProcessor = fileProcessor;
	}

	@ModelAttribute
	public void uploader(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		String resultMessage = fileProcessor.process(file);
		
		attributes.addFlashAttribute(resultMessage);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String uploadFile() {
		return "redirect:/";
	}
}
