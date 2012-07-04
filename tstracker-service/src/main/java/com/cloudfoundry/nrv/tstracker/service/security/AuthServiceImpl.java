package com.cloudfoundry.nrv.tstracker.service.security;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class AuthServiceImpl implements AuthService {

	@Override
	public String getUserName() {
		Subject subject = SecurityUtils.getSubject();
		if(subject != null) {
			Object principal = subject.getPrincipal();
			return principal.toString();
		}		
		return null;
	}

	@Override
	public Map<String, String> getUserLoginAttributes() {
		// TODO: falta averiguar como obtener el username, nombre completo, roles asociados, etc.
		Map<String, String> attrs = null;		
		return attrs;
	}

	@Override
	public void logOut() {
		SecurityUtils.getSubject().logout();
	}

}
