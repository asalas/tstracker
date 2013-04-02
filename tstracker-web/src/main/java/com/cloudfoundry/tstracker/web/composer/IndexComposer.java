package com.cloudfoundry.tstracker.web.composer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.zkoss.spring.context.annotation.EventHandler;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Toolbarbutton;

@org.springframework.stereotype.Component
@Scope("desktop")
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
		 this.hboxMainLayout.getChildren().clear();		
	}

}