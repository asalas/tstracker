package com.terminaltics.tstracker.web.composer.home.projects;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class AllProjectsComposer extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	public Button btnAddProject;
	

	public void onClick$btnAddProject(Event event) {
		Window winAddProject = (Window) Executions.createComponents("/home/projects/add_project.zul", null, null);
        winAddProject.setVisible(true);
        winAddProject.setPosition("center");
	}
	

}
