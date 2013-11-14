package com.cloudfoundry.tstracker.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private static Logger logger = Logger.getLogger(LoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {

		String userName = authentication.getName();

		logger.info("El usuario: " + userName + " ha iniciado sesion.");

		super.onAuthenticationSuccess(request, response, authentication);

	}
}