package com.cloudfoundry.tstracker.web.composer;

import javax.servlet.http.HttpServletResponse;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class IndexComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		Execution exec = Executions.getCurrent();
		HttpServletResponse response = (HttpServletResponse) exec.getNativeResponse();
		response.sendRedirect(response.encodeRedirectURL("marketing/login.zul"));
		exec.setVoided(true);
	}
	
	

}
