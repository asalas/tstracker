package com.cloudfoundry.nrv.tstracker.service.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class AuthServiceImpl implements AuthService {

	@Override
	public String getUserName() {
		Subject subject = SecurityUtils.getSubject();
		String userName = null;
		if(subject != null) {
			Object principal = subject.getPrincipal();
			if(principal != null) {
				userName = principal.toString();
			}			
		}		
		return userName;
	}

	@Override
	public void logOut() {
		SecurityUtils.getSubject().logout();
	}

}