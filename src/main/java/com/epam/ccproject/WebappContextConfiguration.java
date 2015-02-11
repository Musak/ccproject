package com.epam.ccproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.epam.ccproject"})
public class WebappContextConfiguration {

	private static final String TILES_XML_LOCATION = "/WEB-INF/tiles.xml";
	private static final long MAX_FILE_UPLOAD_SIZE = 1000L;
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(MAX_FILE_UPLOAD_SIZE);

		return commonsMultipartResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { TILES_XML_LOCATION });

		return tilesConfigurer;
	}

	@Bean
	public UrlBasedViewResolver viewResorver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(TilesView.class);

		return urlBasedViewResolver;
	}


}
