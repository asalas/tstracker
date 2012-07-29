package com.cloudfoundry.tstracker.web.composer.home;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Toolbarbutton;

public class HomeComposer extends GenericForwardComposer<Component> {	
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Toolbarbutton btnLogout;
	public Toolbarbutton btnShowUserName;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		
		
		this.btnShowUserName.setLabel("mockup");
	}
	
	
	public void onClick$btnLogout(Event event) {
		this.execution.sendRedirect("/j_spring_security_logout");
	}

}
