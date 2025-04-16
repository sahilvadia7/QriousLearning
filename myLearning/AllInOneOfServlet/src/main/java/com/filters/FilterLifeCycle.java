package com.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.*;

public class FilterLifeCycle implements Filter{
	
    private FilterConfig filterConfig;

	
	@Override
	public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 long start = System.currentTimeMillis();
	        System.out.println("Milliseconds in: " + start);
	        chain.doFilter(request, response);
	        long end = System.currentTimeMillis();
	        System.out.println("Milliseconds out: " + end);
	}
	
	public void destroy() { 
			filterConfig = null;
	}

}
