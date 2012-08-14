package com.cloudfoundry.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.web.util.BeansFactory;

public class LoginComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Textbox u;
	
	public Button btnLogin;
	
	private AuthService authService;
	

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		this.authService = BeansFactory.getAuthService();
	}
	
	public void onClick$btnLogin(Event event) throws Exception {
		this.authService.doLogin(this.u.getValue(), "f");
	}
}