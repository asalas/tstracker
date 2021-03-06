package com.terminaltics.tstracker.web.composer.home;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Toolbarbutton;

import com.terminaltics.tstracker.model.Usuario;
import com.terminaltics.tstracker.service.AuthenticationService;
import com.terminaltics.tstracker.support.ProxyContextLoaderListener;
import com.terminaltics.tstracker.web.util.GravatarUtils;

public class HomeComposer extends GenericForwardComposer<Component> {	
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Toolbarbutton btnLogout;
	public Toolbarbutton btnShowUserName;
	
	public Tab tabProjects;
	public Tab tabReports;
	
	public Toolbarbutton btnAllProjects;
	public Toolbarbutton btnClients;
	public Toolbarbutton btnConsultancy;
	
	public Hlayout hlMainContent;
	
	private AuthenticationService authenticationService = 
			(AuthenticationService) ProxyContextLoaderListener.getContext().getBean("authenticationService");
	
	private Usuario usuarioSession;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		this.usuarioSession = this.authenticationService.getCurrentUserInSession();
		
		if (this.usuarioSession != null) {
			this.btnShowUserName.setLabel(this.usuarioSession.getNombre());
			this.btnShowUserName.setImage(GravatarUtils.gravatarImageURL(this.usuarioSession.getEmail()));
		}		
	}	
	
	public void onSelect$tabProjects(Event event) {
		selectOption();
	}
	
	public void onSelect$tabReports(Event event) {
		selectOption();
	}

	private void selectOption() {
		List<Component> children = this.hlMainContent.getChildren();
		if(children != null && !children.isEmpty()) {
			children.clear();
		}
		Label lblMsg = getLblSelectOption();
		children.add(lblMsg);
	}

	private Label getLblSelectOption() {
		Label lblMsg = new Label("Selecciona una opción");
		lblMsg.setSclass("nav_text");
		return lblMsg;
	}
	
	public void onClick$btnAllProjects(Event event) {
		List<Component> children = this.hlMainContent.getChildren();
		if(children != null && !children.isEmpty()) {
			children.clear();
		}		
		Component compAllProjects = Executions.createComponents("projects/all_projects.zul", null, null);
		children.add(compAllProjects);
	}
	
	public void onClick$btnConsultancy(Event event) {
		List<Component> children = this.hlMainContent.getChildren();
		if(children != null && !children.isEmpty()) {
			children.clear();
		}		
		Component compAllConsultancy = Executions.createComponents("consultancy/all_consultancy.zul", null, null);
		children.add(compAllConsultancy);
	}
	
	public void onClick$btnLogout(Event event) {
		this.authenticationService.doLogout();
	}	
	
}