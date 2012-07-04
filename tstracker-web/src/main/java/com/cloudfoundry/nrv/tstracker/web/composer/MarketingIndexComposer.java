package com.cloudfoundry.nrv.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

public class MarketingIndexComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Popup loginPopup;	
	public Toolbar toolBarMain;
	
	public Toolbarbutton btnLogin;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}	
	
	public void onCreate$toolBarMain(Event event) {
		this.loginPopup = (Popup) Executions.createComponents("/templates/login.zul", null, null);
		this.btnLogin.setPopup(loginPopup);
	}
	
}
