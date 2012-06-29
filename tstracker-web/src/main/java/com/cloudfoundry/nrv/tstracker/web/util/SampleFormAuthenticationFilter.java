package com.cloudfoundry.nrv.tstracker.web.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class SampleFormAuthenticationFilter extends FormAuthenticationFilter {
	
	@Override
	public void afterCompletion(ServletRequest request,
			ServletResponse response, Exception exception) throws Exception {
		super.afterCompletion(request, response, exception);
		
		System.out.println("ANTES DE COMPLETAR");
	}
	
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String message = ae.getMessage();
        request.setAttribute(getFailureKeyAttribute(), message);
    }
}