package com.cloudfoundry.nrv.tstracker.web.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cloudfoundry.nrv.tstracker.dao.ClienteDAO;
import com.cloudfoundry.nrv.tstracker.dao.ConsultoraDAO;
import com.cloudfoundry.nrv.tstracker.dao.DesarrolladorDAO;
import com.cloudfoundry.nrv.tstracker.dao.LiderTecnicoDAO;
import com.cloudfoundry.nrv.tstracker.dao.ProyectoDAO;
import com.cloudfoundry.nrv.tstracker.dao.ReporteDAO;
import com.cloudfoundry.nrv.tstracker.dao.TareaDAO;
import com.cloudfoundry.nrv.tstracker.service.ClienteService;
import com.cloudfoundry.nrv.tstracker.service.ConsultoraService;
import com.cloudfoundry.nrv.tstracker.service.DesarrolladorService;
import com.cloudfoundry.nrv.tstracker.service.LiderTecnicoService;
import com.cloudfoundry.nrv.tstracker.service.ProyectoService;
import com.cloudfoundry.nrv.tstracker.service.ReporteService;
import com.cloudfoundry.nrv.tstracker.service.TareaService;
import com.cloudfoundry.nrv.tstracker.service.security.AuthService;

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
		AuthService authService = (AuthService) context.getBean("authService");
		return authService;
	}

}