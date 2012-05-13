package com.cloudfoundry.nrv.tstracker.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cloudfoundry.nrv.tstracker.dao.ClienteDAO;
import com.cloudfoundry.nrv.tstracker.dao.ClienteDAOImpl;
import com.cloudfoundry.nrv.tstracker.service.ClienteService;

public class BeansFactory {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public static ClienteDAO getClienteDAO() {
		ClienteDAO clienteDAO = (ClienteDAO) context.getBean("clienteDAO");
		return clienteDAO;
	}
	
	public static ClienteService getClienteService() {
		ClienteService clienteService = (ClienteService) context.getBean("clienteService");
		return clienteService;
	}

}