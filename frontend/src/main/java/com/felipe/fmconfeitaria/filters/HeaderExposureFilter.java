package com.felipe.fmconfeitaria.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderExposureFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException, ServletException{
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader("acess-control-expose-headers", "location");
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}
}
