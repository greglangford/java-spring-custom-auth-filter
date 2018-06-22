package com.greglangford.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
		
		
		try {
			Algorithm algorithm = Algorithm.HMAC256("secret555");
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqb2JJZCI6IjExMS0xMTEtMTExIiwiaXNzIjoiMTIzNCJ9.hdmuZNBL--J8Gm1qhK5HaVj3CnS10OknwT0deEg6tYw");
			
			jwtAuthenticationToken.setAuthenticated(true);
			return jwtAuthenticationToken;
			
		} catch (JWTVerificationException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(JwtAuthenticationToken.class);
	}
	
}
