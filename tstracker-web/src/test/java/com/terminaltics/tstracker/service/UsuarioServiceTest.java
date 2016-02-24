package com.terminaltics.tstracker.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.terminaltics.tstracker.model.Usuario;

/**
 * Prueba unitaria para el service {@link UsuarioService}
 * 
 * @author asalas
 * 
 */
@ContextConfiguration({"/spring/applicationContext*.xml"})
public class UsuarioServiceTest extends AbstractTestNGSpringContextTests {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test(enabled = true)
	public void testFindByUserName() {
		Usuario dbUsuario = this.usuarioService.findByUserName("asalas");
		Assert.assertNotNull(dbUsuario);
		logger.info("Usuario encontrado! {}", dbUsuario);
	}
}
