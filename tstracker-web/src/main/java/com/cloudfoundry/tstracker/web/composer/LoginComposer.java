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
import com.cloudfoundry.tstracker.web.util.BeansFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@org.springframework.stereotype.Component
@Scope("desktop")
public class LoginComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Textbox u;
	
	public Button btnLogin;
	
	public Toolbarbutton btnForgotPass;
	
        @Autowired
	private AuthService authService;
	

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