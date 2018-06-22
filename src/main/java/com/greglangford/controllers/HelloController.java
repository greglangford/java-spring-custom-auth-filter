package com.greglangford.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("")
	public String index() {
		String token = null;
		
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret555");
			token = JWT.create().withClaim("jobId", "111-111-111").sign(algorithm);
		} catch (JWTCreationException e) {
			
		} catch (UnsupportedEncodingException e) {
			
		}
		
		return token;
	}
}