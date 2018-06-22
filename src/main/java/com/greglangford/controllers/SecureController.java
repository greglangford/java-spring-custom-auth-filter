package com.greglangford.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {
	
	@RequestMapping("")
	public String index() {
		return "This is the secure content";
	}
}
