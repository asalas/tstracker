package com.cloudfoundry.tstracker.web.composer.home.consultancy;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.service.AuthenticationService;
import com.cloudfoundry.tstracker.service.ConsultoraService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class AddConsultancyComposer extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	public Window winAddConsultancy;
	
	public Textbox txtConsultancyName;	
	public Textbox txtConsultancyAddress;	
	public Textbox txtExecutive;
	public Textbox txtEmail;
	public Button btnAddConsultancy;
	public Button btnSaveConsultancy;
	
	private ConsultoraService consultoraService = 
			(ConsultoraService) ProxyContextLoaderListener.getContext().getBean("consultoraService");
	
	private AuthenticationService authenticationService = 
			(AuthenticationService) ProxyContextLoaderListener.getContext().getBean("authenticationService");
	
	public void onClick$btnSaveConsultancy() {
		Desarrollador desarrollador = 
				(Desarrollador)this.authenticationService.getCurrentUserInSession();
		
		List<Desarrollador> listaDesarrolladores = new ArrayList<Desarrollador>();
		listaDesarrolladores.add(desarrollador);
		
		Consultoria nuevaConsultoria = new Consultoria();
		nuevaConsultoria.setId(0L);
		nuevaConsultoria.setNombre(txtConsultancyName.getValue());
		nuevaConsultoria.setDireccion(txtConsultancyAddress.getValue());
		nuevaConsultoria.setEjecutivoCuenta(txtExecutive.getValue());
		nuevaConsultoria.setEmail(txtEmail.getValue());
		nuevaConsultoria.setListaDesarrolladores(listaDesarrolladores);
		
		this.consultoraService.save(nuevaConsultoria);
		
		this.winAddConsultancy.detach();
	}

}