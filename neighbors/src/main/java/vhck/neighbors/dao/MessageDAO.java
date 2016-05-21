package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;

import vhck.neighbors.entity.MessageEntity;

@Stateless
public class MessageDAO extends Persistence{

	public void include(MessageEntity messageEntity) {
        em.persist(messageEntity);
    }
 
    public MessageEntity change(MessageEntity messageEntity) {
        return em.merge(messageEntity);
    }
 
    public void remove(MessageEntity messageEntity) {
        em.remove(em.merge(messageEntity));
    }
	
    public MessageEntity findById(Long id) {
        return em.find(MessageEntity.class, id);
    }	
 
    public void removeById(Long id) {
        em.remove(this.findById(id));
    }
 
    public Long count() {
		return (Long) em.createQuery("SELECT COUNT(me) FROM MessageEntity me").getSingleResult();
    }
    
	@SuppressWarnings("unchecked")
	public List<MessageEntity> findAll() {
    	return em.createQuery("FROM MessageEntity me").getResultList();
    }
}
