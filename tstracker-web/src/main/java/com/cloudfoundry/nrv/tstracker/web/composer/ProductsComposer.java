package com.cloudfoundry.nrv.tstracker.web.composer;

import org.apache.shiro.SecurityUtils;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class ProductsComposer extends GenericForwardComposer {

	public void onClick$home() {
		execution.sendRedirect("/home.zul");
	}

	public void onClick$logout() {
		SecurityUtils.getSubject().logout();
		execution.sendRedirect("/home.zul");
	}
}
