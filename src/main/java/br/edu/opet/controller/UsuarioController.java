package br.edu.opet.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.opet.model.Role;
import br.edu.opet.model.Usuario;

@SessionScoped
@ManagedBean(name="usuarioController")
public class UsuarioController extends AbstractController{

	//Construtor
	public UsuarioController() {}
	
	public static final String INJECTION_NAME = "#(usuarioController)";
	
	private Usuario user;
	
	public boolean isAdmin() {
		return Role.ADMIN.equals(user.getRole());
	}
	
	public boolean isDefaultUser() {
		return Role.USER.equals(user.getRole());
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public String logOut() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "login";
	}
}
