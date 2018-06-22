package com.greglangford.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(jwtAuthenticationProvider);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/hello").permitAll().anyRequest().authenticated().and();
		
		http.addFilterBefore(jwtAuthenticationFilter("/secure"), AnonymousAuthenticationFilter.class);
	}
	
	protected JwtAuthenticationFilter jwtAuthenticationFilter(String url) throws Exception {
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter(url);
		filter.setAuthenticationManager(this.authenticationManager());
		
		return filter;
	}
}
