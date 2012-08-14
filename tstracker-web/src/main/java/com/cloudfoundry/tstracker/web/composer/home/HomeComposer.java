package com.cloudfoundry.tstracker.web.composer.home;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Toolbarbutton;

import com.cloudfoundry.tstracker.model.Usuario;
import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.web.util.BeansFactory;
import com.cloudfoundry.tstracker.web.util.GravatarUtils;

public class HomeComposer extends GenericForwardComposer<Component> {	
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Toolbarbutton btnLogout;
	public Toolbarbutton btnShowUserName;
	
	private AuthService authService;
	
	private Usuario usuarioSession;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		this.authService = BeansFactory.getAuthService();
		
		this.usuarioSession = this.authService.getCurrentUserInSession();
		
		if (this.usuarioSession != null) {
			this.btnShowUserName.setLabel(this.usuarioSession.getNombre());
			this.btnShowUserName.setImage(GravatarUtils.gravatarImageURL(this.usuarioSession.getEmail()));
		}		
	}
	
	
	public void onClick$btnLogout(Event event) {
		this.authService.doLogout();
	}
}