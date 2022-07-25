package com.cg.school.controller;

import com.cg.school.advice.TrackExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerContoller {
	Logger log = LoggerFactory.getLogger(LoggerContoller.class);

	@TrackExecutionTime
	@GetMapping("/test/{name}")
	public String greeting(@PathVariable String name) {
		log.trace(name);
		log.debug("Request {}", name);
		if (name.equalsIgnoreCase("test")) {
			throw new RuntimeException("Opps Exception raised....");
		}
		String response = "Hi " + name + " Welcome to Here";
		log.debug("Response {}", response);
		return response;
	}
}
