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
	public String process(MultipartFile multipartFile) {
		String answString;
		try {
			multipartFile.transferTo(fileNameGenerator.getFile());
			answString = "File successfully uploaded!";
		} catch (IOException e) {
			answString = "Unable to uplod the file.";
		} 
		
		return answString;
	}
}
