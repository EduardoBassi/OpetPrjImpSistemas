package br.edu.opet.dao;

import javax.persistence.NoResultException;

import br.edu.opet.model.Usuario;
import br.edu.opet.util.JPAUtil;

public class UsuarioDao extends Generic<Usuario> {

	//Construtor
	public UsuarioDao() {
		super(Usuario.class);
	}

	public Usuario findByLogin(string login) {
		Usuario user;
		try {
			user = createNamedQuery("Usuario.findByLogin").setParameter("login", login).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}		
	}
	
}
