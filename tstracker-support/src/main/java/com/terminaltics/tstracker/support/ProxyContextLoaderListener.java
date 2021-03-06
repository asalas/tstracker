package com.terminaltics.tstracker.support;

import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

/**
 * Proxy para acceder al contexto de spring desde aquellos recursos Java que no
 * se encuentren dentro de su contexto
 * 
 * @author asalas
 */
public class ProxyContextLoaderListener extends ContextLoaderListener {

    private static Logger log = Logger.getLogger(ProxyContextLoaderListener.class);
    private static WebApplicationContext ctx;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        log.info("Cargando el contexto del aplicativo ...");
        ctx = ContextLoaderListener.getCurrentWebApplicationContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        ctx = null;
    }

    public static WebApplicationContext getContext() {
        return ctx;
    }
}