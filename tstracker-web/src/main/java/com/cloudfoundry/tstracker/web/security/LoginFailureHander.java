package com.cloudfoundry.tstracker.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHander extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		//Messagebox.show("Error al iniciar sesión, verifique sus credenciales.", "Error", Messagebox.OK, Messagebox.ERROR);
		
		super.onAuthenticationFailure(request, response, exception);
		
		System.out.println("LOGIN FAILURE!");
		exception.printStackTrace();
	}
}
