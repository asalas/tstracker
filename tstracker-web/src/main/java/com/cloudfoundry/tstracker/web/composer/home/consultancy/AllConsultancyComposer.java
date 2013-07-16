package com.cloudfoundry.tstracker.web.composer.home.consultancy;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.model.Consultoria;
import com.cloudfoundry.tstracker.service.ConsultoraService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class AllConsultancyComposer extends GenericForwardComposer<Component> {

	private static final long serialVersionUID = 1L;
	
	public  Textbox txtConsultancyName;	
	public Textbox txtConsultancyAddress;	
	public Textbox txtExecutive;
	public Textbox txtEmail;
	public Button btnAddConsultancy;
	public Button btnSaveConsultancy;
	
	private ConsultoraService consultoraService = (ConsultoraService) ProxyContextLoaderListener.getContext().getBean("consultoraService");
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void onClick$btnAddConsultancy() {
		Window winAddConsultancy = (Window) Executions.createComponents("/home/consultancy/add_consultancy.zul", null, null);
		winAddConsultancy.setVisible(true);
		winAddConsultancy.setPosition("center");
	}
	
	public void onClick$btnSaveConsultancy() {
		
		Consultoria nuevaConsultoria = new Consultoria();
		nuevaConsultoria.setId(0L);
		nuevaConsultoria.setNombre(txtConsultancyName.getValue());
		nuevaConsultoria.setDireccion(txtConsultancyAddress.getValue());
		nuevaConsultoria.setEjecutivoCuenta(txtExecutive.getValue());
		
		this.consultoraService.save(nuevaConsultoria);	
	}
	
}
