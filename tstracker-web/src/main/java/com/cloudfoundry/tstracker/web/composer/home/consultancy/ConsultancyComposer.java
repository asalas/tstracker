package com.cloudfoundry.tstracker.web.composer.home.consultancy;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.service.ConsultoraService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class ConsultancyComposer extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ConsultancyComposer.class);
	
	private ConsultoraService consultoraService = 
			(ConsultoraService) ProxyContextLoaderListener.getContext().getBean("consultoraService");

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		log.info("Iniciando el composer para mostrar las consultorias...");
		
		
		
	}
	
	public void onClick$btnAddConsultancy() {
		Window addConsultancyWin = 
				(Window) Executions.createComponents("/home/consultancy/add_consultancy.zul", null, null);
		addConsultancyWin.setVisible(true);
		addConsultancyWin.setPosition("center");
		log.info("Se muestra la ventana para agregar la consultoria.");
	}
	
}