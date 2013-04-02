package com.cloudfoundry.tstracker.dao;

import com.cloudfoundry.tstracker.model.Cliente;
import org.springframework.stereotype.Repository;

/**
 * @author asalas
 * 
 */
@Repository(value = "clienteDAO")
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDAO {

	

}
