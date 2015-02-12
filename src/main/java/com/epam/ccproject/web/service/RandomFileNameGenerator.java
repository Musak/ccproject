package com.epam.ccproject.web.service;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFileNameGenerator implements FileNameGenerator {

	private RandomIdentifierGenerator identifierGenerator;

	private String rootPath;
	private String tempFolderName;

	@Autowired
	public RandomFileNameGenerator(RandomIdentifierGenerator identifierGenerator) {
		this.identifierGenerator = identifierGenerator;
	}

	@Value("#{AppSettings['project.home']}/#{AppSettings['upload.home']}")
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	@Value("#{AppSettings['tempFolderName']}")
	public void setTempFolderName(String tempFolderName) {
		this.tempFolderName = tempFolderName;
	}
	
	@Override
	public File getFile() {
		File dir = new File(getDirPath());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		return new File(dir.getAbsolutePath() + File.separator + getFileName());
	}

	private String getFileName() {
		return identifierGenerator.getRandomIdentifier() + ".csv";
	}

	private String getDirPath() {
		return rootPath + File.separator + tempFolderName;
	}


}
