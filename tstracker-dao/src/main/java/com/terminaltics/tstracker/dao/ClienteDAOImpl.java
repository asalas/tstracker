package com.terminaltics.tstracker.dao;

import com.terminaltics.tstracker.model.Cliente;
import org.springframework.stereotype.Repository;

/**
 * @author asalas
 * 
 */
@Repository(value = "clienteDAO")
public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDAO {

	

}
