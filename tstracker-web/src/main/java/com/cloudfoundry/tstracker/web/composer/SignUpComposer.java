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

import com.cloudfoundry.tstracker.model.Usuario;
import com.cloudfoundry.tstracker.service.AuthService;
import com.cloudfoundry.tstracker.service.UsuarioService;
import com.cloudfoundry.tstracker.web.util.ContantsTstracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@org.springframework.stereotype.Component
@Scope("desktop")
public class SignUpComposer extends GenericForwardComposer<Component> {	

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
        @Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AuthService authService;
	
	public Textbox u;

	public Textbox p;

	public Textbox retypedPassword;

	public Textbox name;

	public Textbox lastName;

	public Textbox email;

	public Textbox address;

	public Textbox phone;

	public Button btnSubmit;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);		
		
	}

	private String getU() throws WrongValueException {		
		String userName = this.u.getValue();
		if (Strings.isBlank(userName)) {
			throw new WrongValueException(this.u, ContantsTstracker.NO_EMPTY);
		} else if(!StringUtils.isAlphanumericSpace(userName)) {
			throw new WrongValueException(this.u, ContantsTstracker.ALPHA_USER_NAME_NO_EMPTY);
		}
		
		Usuario dbUsuario = this.usuarioService.findById(userName);
		if (dbUsuario != null) {
			throw new WrongValueException(this.u, "Este nombre de usuario ya está siendo utilizado.");
		}
		
		return userName;
	}
	
	private String getP() throws WrongValueException {
		String password = this.p.getValue();
		if (Strings.isBlank(password)) {
			throw new WrongValueException(this.p, ContantsTstracker.NO_EMPTY);
		}
		return password;
	}
	
	private String getRetypedPassword() throws WrongValueException {		
		String retypedPassword = this.retypedPassword.getValue();
		if (Strings.isBlank(retypedPassword)) {
			throw new WrongValueException(this.retypedPassword, ContantsTstracker.NO_EMPTY);
		}
		
		String password = this.p.getValue();		
		if (password == null || retypedPassword == null || !password.equals(retypedPassword)) {
			throw new WrongValueException(this.retypedPassword, ContantsTstracker.PASSWORD_MISMATCH);
		}		
		
		return retypedPassword;
	}
	
	
	private String getName() throws WrongValueException {
		String name = this.name.getValue();
		if (Strings.isBlank(name)) {
			throw new WrongValueException(this.name,ContantsTstracker.NO_EMPTY);
		}
		return name;
	}
	
	
	private String getLastName() throws WrongValueException {
		String lastName = this.lastName.getValue();
		if (Strings.isBlank(lastName)) {
			throw new WrongValueException(this.lastName, ContantsTstracker.NO_EMPTY);
		}
		return lastName;
	}
	
	private String getEmail() throws WrongValueException {
		String email = this.email.getValue();
		if (Strings.isBlank(email)) {
			throw new WrongValueException(this.email, ContantsTstracker.NO_EMPTY);
		}
		
		if(email == null || !email.matches(".+@.+\\.[a-z]+")) {
			throw new WrongValueException(this.email, ContantsTstracker.EMAIL_INVALID);
		}
		
		Usuario dbUsuario = this.usuarioService.findByEmail(email);
		if (dbUsuario != null) {
			throw new WrongValueException(this.email, "Este email ya está siendo utilizado.");
		}
		
		return email;
	}
	
	private String getAddress() throws WrongValueException {
		String address = this.address.getValue();
		if (Strings.isBlank(address)) {
			throw new WrongValueException(this.address, ContantsTstracker.NO_EMPTY);
		}
		return address;
	}
	
	private String getPhone() throws WrongValueException {
		String phone = this.phone.getValue();
		if (Strings.isBlank(phone)) {
			throw new WrongValueException(this.phone, ContantsTstracker.NO_EMPTY);
		} else if (!StringUtils.isNumeric(phone)) {
			throw new WrongValueException(this.phone, ContantsTstracker.PHONE_BE_NUMERIC);
		}
		return phone;
	}
	
	public void onClick$btnSubmit(Event event) throws Exception {		
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(getU());
		usuario.setPassword(getP());
		getRetypedPassword();
		usuario.setNombre(getName());
		usuario.setApellidos(getLastName());
		usuario.setEmail(getEmail());
		usuario.setDireccion(getAddress());
		usuario.setTelefono(getPhone());			
		
		// se persisten los datos del nuevo desarrollador
		try {
			this.usuarioService.registraNuevoDessarrollador(usuario);
		} catch (Exception e) {
			Messagebox.show("Se ha producido un error al intentar guardar la nueva cuenta de usuario.", 
					"Error Registro de Usuarios", 
					Messagebox.OK, 
					Messagebox.ERROR);
			return;
		}
		
		this.authService.doLogin(usuario.getNombreUsuario(), "f");		
	}

}