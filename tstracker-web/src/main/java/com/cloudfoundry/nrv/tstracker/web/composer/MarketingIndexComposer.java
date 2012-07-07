package com.cloudfoundry.nrv.tstracker.web.composer;

import org.apache.commons.lang.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.cloudfoundry.nrv.tstracker.service.security.AuthService;
import com.cloudfoundry.nrv.tstracker.web.spring.BeansFactory;

public class MarketingIndexComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private AuthService authService;

	public Popup loginPopup;	
	public Toolbar toolBarMain;	
	public Toolbarbutton btnLogin;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		this.authService = BeansFactory.getAuthService();
		
		String userName = this.authService.getUserName();
		
		if(StringUtils.isNotEmpty(userName)) {
			this.execution.sendRedirect("home/");
		}
		
	}
	
	public void onCreate$toolBarMain(Event event) {
		this.loginPopup = (Popup) Executions.createComponents("/templates/login.zul", null, null);
		this.btnLogin.setPopup(loginPopup);
	}
	
}
