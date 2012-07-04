package com.cloudfoundry.nrv.tstracker.web.composer.home;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Toolbarbutton;

import com.cloudfoundry.nrv.tstracker.service.security.AuthService;
import com.cloudfoundry.nrv.tstracker.web.spring.BeansFactory;

public class TstrackerHomeComposer extends GenericForwardComposer<Component> {	
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	private AuthService authService;
	
	public Toolbarbutton btnLogout;
	public Toolbarbutton btnShowUserName;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		this.authService = BeansFactory.getAuthService();
		
		this.btnShowUserName.setLabel(this.authService.getUserName());
	}
	
	
	public void onClick$btnLogout(Event event) {
		this.authService.logOut();
		this.execution.sendRedirect("/");
	}

}
