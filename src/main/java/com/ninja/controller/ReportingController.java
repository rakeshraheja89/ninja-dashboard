package com.ninja.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.model.ExchangeData;
import com.ninja.service.ReportingSPI;

@RestController
public class ReportingController {

	@Autowired
	ReportingSPI reportingSPI;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello User ! application is running";
	
	@Value("${filePath}")
	private String filePath;

	@RequestMapping("/test")
	public String welcome() {
		return message;
	}

	@RequestMapping("/download")
	public Object displayData(Map<String, Object> model) {
		List<ExchangeData> data = reportingSPI.downloadData(filePath);
		model.put("data", data);
		return model;
	}

}
