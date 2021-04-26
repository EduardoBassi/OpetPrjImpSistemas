package br.edu.opet.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.edu.opet.dao.UsuarioDao;
import br.edu.opet.model.Usuario;

@RequestScoped
@ManagedBean
public class LoginController extends AbstractController {

	//Construtor
	public LoginController() {}
	
	@ManagedProperty(value = UsuarioController.INJECTION_NAME)
	private UsuarioController usuarioController;
	
	private String login;
	private String senha;
	
	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}
	
	private Usuario isValidLogin(String login, String senha) {
		Usuario user new UsuarioDao().findByLogin(login);
		if(user == null || !senha.equals(user.getSenha())) {
			return null;
		}
		return user;
	}
	
	public String entrar() {
		Usuario user = isValidLogin(login, senha);
		if(user != null) {
			usuarioController.setUser(user);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			request.getSession().setAttribute("user", user);
			return "index";
		}
		displayErrorMessage("Verifique seu Login e Senha!");
		return null;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
