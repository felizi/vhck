package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;

import vhck.neighbors.entity.group.GroupEntity;

@Stateless
public class GroupDAO extends Persistence{

	public void include(GroupEntity groupEntity) {
        em.persist(groupEntity);
    }
 
    public GroupEntity change(GroupEntity groupEntity) {
        return em.merge(groupEntity);
    }
 
    public void remove(GroupEntity groupEntity) {
        em.remove(em.merge(groupEntity));
    }
	
    public GroupEntity findById(Long id) {
        return em.find(GroupEntity.class, id);
    }	
 
    public void removeById(Long id) {
        em.remove(this.findById(id));
    }
 
    public Long count() {
		return (Long) em.createQuery("SELECT COUNT(ge) FROM GroupEntity ge").getSingleResult();
    }
    
	@SuppressWarnings("unchecked")
	public List<GroupEntity> findAll() {
    	return em.createQuery("FROM GroupEntity ge").getResultList();
    }
}
