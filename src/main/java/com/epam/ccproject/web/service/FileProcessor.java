package com.epam.ccproject.web.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessor {
	Boolean process(MultipartFile file);
}
