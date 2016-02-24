package com.terminaltics.tstracker.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHander extends SimpleUrlAuthenticationFailureHandler {

	private static Logger logger = Logger.getLogger(LoginFailureHander.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		super.onAuthenticationFailure(request, response, exception);

		logger.info("Error al inicio de sesion " + exception.getMessage());
	}
}
