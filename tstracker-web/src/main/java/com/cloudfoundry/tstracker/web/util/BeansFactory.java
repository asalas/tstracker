package com.cloudfoundry.tstracker.web.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cloudfoundry.tstracker.dao.ClienteDAO;
import com.cloudfoundry.tstracker.dao.ConsultoraDAO;
import com.cloudfoundry.tstracker.dao.DesarrolladorDAO;
import com.cloudfoundry.tstracker.dao.LiderTecnicoDAO;
import com.cloudfoundry.tstracker.dao.ProyectoDAO;
import com.cloudfoundry.tstracker.dao.ReporteDAO;
import com.cloudfoundry.tstracker.dao.TareaDAO;
import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.service.ClienteService;
import com.cloudfoundry.tstracker.service.ConsultoraService;
import com.cloudfoundry.tstracker.service.DesarrolladorService;
import com.cloudfoundry.tstracker.service.LiderTecnicoService;
import com.cloudfoundry.tstracker.service.ProyectoService;
import com.cloudfoundry.tstracker.service.ReporteService;
import com.cloudfoundry.tstracker.service.TareaService;

public class BeansFactory {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static ClienteDAO getClienteDAO() {
		ClienteDAO clienteDAO = (ClienteDAO) context.getBean("clienteDAO");
		return clienteDAO;
	}

	public static DesarrolladorDAO getDesarrolladorDAO() {
		DesarrolladorDAO desarrolladorDAO = (DesarrolladorDAO) context
				.getBean("desarrolladorDAO");
		return desarrolladorDAO;
	}

	public static LiderTecnicoDAO getLiderTecnicoDAO() {
		LiderTecnicoDAO liderTecnicoDAO = (LiderTecnicoDAO) context
				.getBean("liderTecnicoDAO");
		return liderTecnicoDAO;
	}

	public static ConsultoraDAO getConsultoraDAO() {
		ConsultoraDAO consultoraDAO = (ConsultoraDAO) context
				.getBean("consultoraDAO");
		return consultoraDAO;
	}

	public static ProyectoDAO getProyectoDAO() {
		ProyectoDAO proyectoDAO = (ProyectoDAO) context.getBean("proyectoDAO");
		return proyectoDAO;
	}

	public static TareaDAO getTareaDAO() {
		TareaDAO tareaDAO = (TareaDAO) context.getBean("tareaDAO");
		return tareaDAO;
	}

	public static ReporteDAO getReporteDAO() {
		ReporteDAO reporteDAO = (ReporteDAO) context.getBean("reporteDAO");
		return reporteDAO;
	}

	public static ClienteService getClienteService() {
		ClienteService clienteService = (ClienteService) context
				.getBean("clienteService");
		return clienteService;
	}

	public static DesarrolladorService getDesarrolladorService() {
		DesarrolladorService desarrolladorService = (DesarrolladorService) context
				.getBean("desarrolladorService");
		return desarrolladorService;
	}

	public static LiderTecnicoService getLiderTecnicoService() {
		LiderTecnicoService liderTecnicoService = (LiderTecnicoService) context
				.getBean("liderTecnicoService");
		return liderTecnicoService;
	}

	public static ConsultoraService getConsultoraService() {
		ConsultoraService consultoraService = (ConsultoraService) context
				.getBean("consultoraService");
		return consultoraService;
	}

	public static ProyectoService getProyectoService() {
		ProyectoService proyectoService = (ProyectoService) context
				.getBean("proyectoService");
		return proyectoService;
	}

	public static TareaService getTareaService() {
		TareaService tareaService = (TareaService) context
				.getBean("tareaService");
		return tareaService;
	}

	public static ReporteService getReporteService() {
		ReporteService reporteService = (ReporteService) context
				.getBean("reporteService");
		return reporteService;
	}
	
	public static AuthService getAuthService() {
		AuthService authService = (AuthService) context
				.getBean("authService");
		return authService;
	}
}