package com.cloudfoundry.tstracker.test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.model.Proyecto;
import com.cloudfoundry.tstracker.service.DesarrolladorService;
import com.cloudfoundry.tstracker.service.ProyectoService;
import com.cloudfoundry.tstracker.web.util.BeansFactory;

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
