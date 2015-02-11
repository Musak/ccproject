package com.epam.ccproject.web.service;

import java.io.File;

public interface FileNameGenerator {

	File getFile();
	void setRootPath(String rootPath);
	void setTempFolderName(String tempFolderName);
}
