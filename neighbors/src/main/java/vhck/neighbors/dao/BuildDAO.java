package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;

import vhck.neighbors.entity.BuildEntity;

@Stateless
public class BuildDAO extends Persistence {

	public void include(BuildEntity buildEntity) {
        em.persist(buildEntity);
    }
 
    public BuildEntity change(BuildEntity buildEntity) {
        return em.merge(buildEntity);
    }
 
    public void remove(BuildEntity buildEntity) {
        em.remove(em.merge(buildEntity));
    }
	
    public BuildEntity findById(Long id) {
        return em.find(BuildEntity.class, id);
    }	
 
    public void removeById(Long id) {
        em.remove(this.findById(id));
    }
 
    public Long count() {
		return (Long) em.createQuery("SELECT COUNT(be) FROM BuildEntity be").getSingleResult();
    }
    
	@SuppressWarnings("unchecked")
	public List<BuildEntity> findAll() {
    	return em.createQuery("FROM BuildEntity be").getResultList();
    }
}
