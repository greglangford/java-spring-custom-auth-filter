package com.greglangford.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.greglangford.config.security.JwtAuthenticationFilterSuccessHandler;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	
    public JwtAuthenticationFilter(String url) {
    	super("/secure");
    	setAuthenticationSuccessHandler(new JwtAuthenticationFilterSuccessHandler());
    }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken("test", "test2");
		return getAuthenticationManager().authenticate(jwtAuthenticationToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
	}
}
