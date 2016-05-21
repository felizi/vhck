package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class GenericDAO<T> extends Persistence {

    public void include(T entity) {
        em.persist(entity);
    }
 
    public T change(T entity) {
        return em.merge(entity);
    }
 
    public void remove(T entity) {
        em.remove(em.merge(entity));
    }
	
    public T findById(Class<T> clazz, Long id) {
        return em.find(clazz, id);
    }	
 
    public void removeById(Class<T> clazz, Long id) {
        T entity = findById(clazz, id);
        em.remove(entity);
    }
 
    public Long count(Class<T> clazz) {
		return (Long) em.createQuery("SELECT COUNT(c) FROM " + clazz.getSimpleName() + " c").getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz) {
    	return em.createQuery("FROM " + clazz.getSimpleName() + " c").getResultList();
    }
}