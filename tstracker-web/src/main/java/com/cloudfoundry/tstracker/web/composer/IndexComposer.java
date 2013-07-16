package com.cloudfoundry.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Toolbarbutton;

public class IndexComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
        
	public Hbox hboxMainLayout;
        
	public Toolbarbutton btnHome;
        
	public Toolbarbutton btnSignUp;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Executions.createComponents("login.zul", this.hboxMainLayout, null);

	}


	public void onClick$btnHome(Event event) throws Exception {
	
		resetHBoxMainLayout();
		Executions.createComponents("login.zul", this.hboxMainLayout, null);
	}	

	public void onClick$btnSignUp(Event event) throws Exception {
		resetHBoxMainLayout();
		Executions.createComponents("signup.zul", this.hboxMainLayout, null);
	}
	
	private void resetHBoxMainLayout() {
		Clients.showBusy("d(o.o)b");
		Components.removeAllChildren(this.hboxMainLayout);
		Clients.clearBusy();
	}

}