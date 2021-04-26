package br.edu.opet.dao;

import java.io.Serializable;
import javax.transaction.Transactional;
import br.edu.opet.util.JPAUtil;
import java.util.List;
import java.persistence.Query;
import java.persistence.TypedQuery;

@Tansactional
public class Generic implements Serializable{
	
	private Class<T> entityClass;	
	
	public Generic(Class<T> entity) {
		this.entityClass = entity;
	}
	
	//Método Salvar
	public void save(T entity) {
		try {
			JPAUtil.getEntityManager().persist(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}
	
	//Método Deletar
	public void delete(Object id, Class<T> entity) {
		try {
			JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().getReference(entity, id));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	//Método Atualizar
	public T update(T entity) {
		return JPAUtil.getEntityManager().merge(entity);
	}
	
	//Método Busca por Id
	public T findById(int entityId) {
		return JPAUtil.getEntityManager().find(entityClass, entityId);
	}

	//Método Busca referência
	public T findReferenceOnly(int entityID) {
		return JPAUtil.getEntityManager().getReference(entityClass, entityID);
	}
	
	//Método Busca todos
	public List<T> findAll(){
		CriteriaQuery<T> cq = (CriteriaQuery<T>) JPAUtil.getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return JPAUtil.getEntityManager().createQuery(cq).getResultList();
	}
	
	public TypedQuery<T> createNamedQuery(String query) {
		return JPAUtil.getEntityManager().createNamedQuery(query, entityClass);
	}
	
	public Query createNativeQuery(string query) {
		return JPAUtil.getEntityManager().createNativeQuery(query, entityClass);
	}
	
}
