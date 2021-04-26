package br.edu.opet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory em;
	private static EntityManager entityManager; 

	static {
		em = Persistence.createEntityManagerFactory("OPET_PU");
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = em.getEntityManager();
		}
		return entityManager;
	} 
	
}
