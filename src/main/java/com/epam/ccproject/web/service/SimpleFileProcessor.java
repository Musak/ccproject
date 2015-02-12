package com.epam.ccproject.web.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SimpleFileProcessor implements FileProcessor {

	private FileNameGenerator fileNameGenerator; 

	@Autowired
	public SimpleFileProcessor(FileNameGenerator fileNameGenerator) {
		this.fileNameGenerator = fileNameGenerator;
	}
	
	@Override
	public Boolean process(MultipartFile multipartFile) {
		Boolean answ;
		try {
			multipartFile.transferTo(fileNameGenerator.getFile());
			answ = true;
		} catch (IOException e) {
			answ = false;
		} 
		
		return answ;
	}
}
