package com.cloudfoundry.tstracker.web.composer.home.consultancy;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.service.AuthenticationService;
import com.cloudfoundry.tstracker.service.ConsultoraService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class ConsultancyComposer extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(ConsultancyComposer.class);
	
	public Listbox lstConsultorias;
	
	private ConsultoriaModel consultoriaModel;
	
	private ConsultoraService consultoraService = 
			(ConsultoraService) ProxyContextLoaderListener.getContext().getBean("consultoraService");

	private AuthenticationService authenticationService = 
			(AuthenticationService) ProxyContextLoaderListener.getContext().getBean("authenticationService");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		log.info("Iniciando el composer para mostrar las consultorias...");
		
		Desarrollador desarrollador = (Desarrollador)this.authenticationService.getCurrentUserInSession();
		
		
		
		List<Consultoria> listaConsultorias = this.consultoraService.getByDesarrollador(desarrollador);
		this.consultoriaModel = new ConsultoriaModel();
		this.consultoriaModel.setListaConsultorias(listaConsultorias);
		
		this.lstConsultorias.setModel(consultoriaModel);
		
	}
	
	public void onClick$btnAddConsultancy() {
		Window addConsultancyWin = 
				(Window) Executions.createComponents("/home/consultancy/add_consultancy.zul", null, null);
		addConsultancyWin.setVisible(true);
		addConsultancyWin.setPosition("center");
		log.info("Se muestra la ventana para agregar la consultoria.");
	}
	
}