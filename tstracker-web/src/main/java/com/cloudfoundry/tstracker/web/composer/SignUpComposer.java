package com.cloudfoundry.tstracker.web.composer;

import org.apache.commons.lang.StringUtils;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.cloudfoundry.tstracker.model.Desarrollador;
import com.cloudfoundry.tstracker.model.Usuario;
import com.cloudfoundry.tstracker.service.AuthenticationService;
import com.cloudfoundry.tstracker.service.UsuarioService;
import com.cloudfoundry.tstracker.support.ProxyContextLoaderListener;
import com.cloudfoundry.tstracker.support.messages.MessagesReader;


/**
 * Composer para el registro de usuarios.
 * 
 * @author asalas
 *
 */
public class SignUpComposer extends GenericForwardComposer<Component> {

    private static final long serialVersionUID = 1L;
    
    // propiedades de la UI
    public Textbox u;
    public Textbox p;
    public Textbox retypedPassword;
    public Textbox name;
    public Textbox lastName;
    public Textbox email;
    public Textbox address;
    public Textbox phone;
    public Button btnSubmit;
    
    // servicios a utilizar
    private UsuarioService usuarioService =
            (UsuarioService) ProxyContextLoaderListener.getContext().getBean("usuarioService");
    private AuthenticationService authenticationService =
            (AuthenticationService) ProxyContextLoaderListener.getContext().getBean("authenticationService");

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

    }

    private String getU() throws WrongValueException {
        String userName = this.u.getValue();
        if (Strings.isBlank(userName)) {
            throw new WrongValueException(this.u, MessagesReader.getInstance().getString("field.not.empty"));
        } else if (!StringUtils.isAlphanumericSpace(userName)) {
            throw new WrongValueException(this.u, MessagesReader.getInstance().getString("alphausername.not.empty"));
        }

        Usuario dbUsuario = this.usuarioService.findById(userName);
        if (dbUsuario != null) {
            throw new WrongValueException(this.u, MessagesReader.getInstance().getString("signup.username.repeated"));
        }

        return userName;
    }

    private String getP() throws WrongValueException {
        String password = this.p.getValue();
        if (Strings.isBlank(password)) {
            throw new WrongValueException(this.p, MessagesReader.getInstance().getString("field.not.empty"));
        }
        return password;
    }

    private String getRetypedPassword() throws WrongValueException {
        String retypedPassword = this.retypedPassword.getValue();
        if (Strings.isBlank(retypedPassword)) {
            throw new WrongValueException(this.retypedPassword, MessagesReader.getInstance().getString("field.not.empty"));
        }

        String password = this.p.getValue();
        if (password == null || retypedPassword == null || !password.equals(retypedPassword)) {
            throw new WrongValueException(this.retypedPassword, MessagesReader.getInstance().getString("password.confirm.mismatch"));
        }

        return retypedPassword;
    }

    private String getName() throws WrongValueException {
        String name = this.name.getValue();
        if (Strings.isBlank(name)) {
            throw new WrongValueException(this.name, MessagesReader.getInstance().getString("field.not.empty"));
        }
        return name;
    }

    private String getLastName() throws WrongValueException {
        String lastName = this.lastName.getValue();
        if (Strings.isBlank(lastName)) {
            throw new WrongValueException(this.lastName, MessagesReader.getInstance().getString("field.not.empty"));
        }
        return lastName;
    }

    private String getEmail() throws WrongValueException {
        String email = this.email.getValue();
        if (Strings.isBlank(email)) {
            throw new WrongValueException(this.email, MessagesReader.getInstance().getString("field.not.empty"));
        }

        if (email == null || !email.matches(".+@.+\\.[a-z]+")) {
            throw new WrongValueException(this.email, MessagesReader.getInstance().getString("email.invalid"));
        }

        Usuario dbUsuario = this.usuarioService.findByEmail(email);
        if (dbUsuario != null) {
            throw new WrongValueException(this.email, MessagesReader.getInstance().getString("email.repeated"));
        }

        return email;
    }

    private String getAddress() throws WrongValueException {
        String address = this.address.getValue();
        if (Strings.isBlank(address)) {
            throw new WrongValueException(this.address, MessagesReader.getInstance().getString("field.not.empty"));
        }
        return address;
    }

    private String getPhone() throws WrongValueException {
        String phone = this.phone.getValue();
        if (Strings.isBlank(phone)) {
            throw new WrongValueException(this.phone, MessagesReader.getInstance().getString("field.not.empty"));
        } else if (!StringUtils.isNumeric(phone)) {
            throw new WrongValueException(this.phone, MessagesReader.getInstance().getString("phone.be.numeric"));
        }
        return phone;
    }

    public void onClick$btnSubmit(Event event) throws Exception {
        Desarrollador desarrollador = new Desarrollador();
        desarrollador.setNombreUsuario(getU());
        desarrollador.setPassword(getP());
        getRetypedPassword();
        desarrollador.setNombre(getName());
        desarrollador.setApellidos(getLastName());
        desarrollador.setEmail(getEmail());
        desarrollador.setDireccion(getAddress());
        desarrollador.setTelefono(getPhone());

        // se persisten los datos del nuevo desarrollador
        try {
            this.usuarioService.registraNuevoDessarrollador(desarrollador);
        } catch (Exception e) {
            Messagebox.show(MessagesReader.getInstance().getString("signup.error.register"),
                    MessagesReader.getInstance().getString("signup.error.register.header"),
                    Messagebox.OK,
                    Messagebox.ERROR);
            return;
        }

        this.authenticationService.doLogin(desarrollador.getNombreUsuario(), "f");
    }
}