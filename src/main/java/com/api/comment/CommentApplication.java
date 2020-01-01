package com.api.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CommentApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CommentApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Logger implemented");
		SpringApplication.run(CommentApplication.class, args);
	}
}
