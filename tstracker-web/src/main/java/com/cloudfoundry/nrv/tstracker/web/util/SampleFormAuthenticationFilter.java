package com.cloudfoundry.nrv.tstracker.web.util;

import javax.servlet.ServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class SampleFormAuthenticationFilter extends FormAuthenticationFilter {
	
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String message = ae.getMessage();
        request.setAttribute(getFailureKeyAttribute(), message);
    }
}