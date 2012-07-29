package com.cloudfoundry.tstracker.web.composer;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;

public class LoginComposer extends GenericForwardComposer<Component> {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	public Popup loginPopup;
	public Toolbar toolBarMain;

	public Textbox user;
	public Textbox pass;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

}