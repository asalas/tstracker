package com.cloudfoundry.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;

public class LoginComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Popup loginPopup;
	public Toolbar toolBarMain;

	public Textbox u;
	public Textbox p;
	
	public Button btnLogin;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void onClick$btnLogin(Event event) throws Exception {
		Executions.getCurrent().getSession().setAttribute("current_user", this.u.getValue());
		Clients.submitForm("f");	
	}

}