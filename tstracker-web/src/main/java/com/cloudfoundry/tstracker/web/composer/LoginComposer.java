package com.cloudfoundry.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class LoginComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Textbox u;
	
	public Button btnLogin;
	
	public Toolbarbutton btnForgotPass;
	
	private AuthService authService = (AuthService) ProxyContextLoaderListener.getContext().getBean("authService");
	

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void onClick$btnLogin(Event event) throws Exception {
		this.authService.doLogin(this.u.getValue(), "f");
	}
	
	public void onClick$btnForgotPass(Event event) throws Exception {
		Window winForgotPassword = (Window)Executions.createComponents("forgot_password.zul", null, null);
		winForgotPassword.setVisible(true);
		winForgotPassword.setPosition("center");
		//winForgotPassword.doOverlapped();
	}
}