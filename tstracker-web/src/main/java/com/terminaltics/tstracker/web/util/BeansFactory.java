package com.terminaltics.tstracker.web.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansFactory {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("/spring/applicationContext*.xml");
	}

	/**
	 * Obtiene un Bean por su nombre especifico
	 * 
	 * @param nombreBean
	 * @return
	 */
	public static Object getBeanByName(String nombreBean) {
		return context.getBean(nombreBean);
	}
}