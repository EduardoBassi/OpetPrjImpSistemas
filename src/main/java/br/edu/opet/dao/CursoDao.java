package br.edu.opet.dao;

import javax.persistence.NoResultException;

import br.edu.opet.model.Curso;
import br.edu.opet.util.JPAUtil;

public class CursoDao extends Generic<Curso> {

	public CursoDao() {
		super(Curso.class);
	}

	public Curso findByNome(string curso) {
		Curso curso;
		try {
			curso = createNamedQuery("Curso.findByNome").setParameter("nome", nome).getSingleResult();
			return curso;
		} catch (NoResultException e) {
			return null;
		}		
	}
	
}
