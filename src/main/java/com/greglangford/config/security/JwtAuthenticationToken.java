package com.greglangford.config.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
	
	private static final long serialVersionUID = 1L;
	private String token;
	private String jobId;

	public JwtAuthenticationToken(String token, String jobId) {
		super(null);
		this.token = token;
		this.jobId = jobId;
		setAuthenticated(false);
	}
	
	public JwtAuthenticationToken(String token, String jobId, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.token = token;
		this.jobId = jobId;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
		
}
