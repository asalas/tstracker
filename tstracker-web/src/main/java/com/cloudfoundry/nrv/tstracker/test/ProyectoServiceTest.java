package com.cloudfoundry.nrv.tstracker.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cloudfoundry.nrv.tstracker.model.Desarrollador;
import com.cloudfoundry.nrv.tstracker.model.Proyecto;
import com.cloudfoundry.nrv.tstracker.service.DesarrolladorService;
import com.cloudfoundry.nrv.tstracker.service.ProyectoService;
import com.cloudfoundry.nrv.tstracker.web.spring.BeansFactory;

import junit.framework.TestCase;

public class ProyectoServiceTest extends TestCase {
	
	private ProyectoService proyectoService;
	
	private DesarrolladorService desarrolladorService;
	
	@Before
	public void setUp() {
		this.proyectoService = BeansFactory.getProyectoService();
		this.desarrolladorService = BeansFactory.getDesarrolladorService();
	}
	
	@Test
	public void testGetAllByDesarrollador() {
		
		Desarrollador developer = new Desarrollador();
		developer.setNombreUsuario("asalas");
		
		Desarrollador dbDeveloper = this.desarrolladorService.findById(developer.getNombreUsuario());
		if(dbDeveloper != null) {
			List<Proyecto> listaProyectos = dbDeveloper.getListaProyectos();
		}
		
		List<Proyecto> allByDesarrollador = this.proyectoService.getAllByDesarrollador(developer);
		
		
		
	}

}
