package com.cloudfoundry.tstracker.web.composer;

import org.apache.commons.lang.StringUtils;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;

public class LoginComposer extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = 1L;
    public Textbox u;
    public Textbox p;
    public Button btnLogin;
    public Toolbarbutton btnForgotPass;
    private AuthService authService = (AuthService) ProxyContextLoaderListener.getContext().getBean("authService");

    @Override
    public void doAfterCompose(Component comp) throws Exception {
    	super.doAfterCompose(comp);
    }

    public void onClick$btnLogin(Event event) throws Exception {
    	
        if (Strings.isBlank(this.u.getValue()) || StringUtils.isBlank(this.p.getValue())) {
            Clients.showNotification("El nombre de usuario y password son requeridos.", 
            		Clients.NOTIFICATION_TYPE_ERROR, 
            		this.btnLogin, 
            		"after_center", 
            		2000, 
            		true);
        } else {
            this.authService.doLogin(this.u.getValue(), "f");
        }

    }

    public void onClick$btnForgotPass(Event event) throws Exception {
        Window winForgotPassword = (Window) Executions.createComponents("forgot_password.zul", null, null);
        winForgotPassword.setVisible(true);
        winForgotPassword.setPosition("center");
        //winForgotPassword.doOverlapped();
    }
}