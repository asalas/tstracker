package com.terminaltics.tstracker.dao;

import com.terminaltics.tstracker.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author
 * asalas
 */
@ContextConfiguration({"/spring/applicationContext*.xml"})
public class TestAutowiredBean extends AbstractTestNGSpringContextTests {

    @Autowired
    private ClienteDAO clienteDAO;
    
    @Autowired
    private AuthenticationService authenticationService;

    @Test(enabled = true)
    public void startUp() {
        Assert.assertNotNull(this.clienteDAO);
        Assert.assertNotNull(this.authenticationService);
    }
}
