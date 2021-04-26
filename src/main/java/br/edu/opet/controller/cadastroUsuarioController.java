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
public class cadastroUsuarioController extends AbstractController {

	//Construtor
	public cadastroUsuarioController() {}
	
	public String cadastrar() {
		Usuario user = new Usuario();
		if(user.cadastroUsuario()) {
			usuarioController.setUser(user);
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			request.getSession().setAttribute("user", user);
			return "index";
		}
		displayErrorMessage("Não foi possível fazer o cadastro!");
		return null;
	}
	
}
