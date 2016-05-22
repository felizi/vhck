package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.entity.ChannelEntity;

@Stateless
public class ChannelDAO extends Persistence{

	public void include(ChannelEntity channelEntity) {
        em.persist(channelEntity);
    }
 
    public ChannelEntity change(ChannelEntity channelEntity) {
        return em.merge(channelEntity);
    }
 
    public void remove(ChannelEntity channelEntity) {
        em.remove(em.merge(channelEntity));
    }
	
    public ChannelEntity findById(Long id) {
        return em.find(ChannelEntity.class, id);
    }	
 
    public void removeById(Long id) {
        em.remove(this.findById(id));
    }
 
    public Long count() {
		return (Long) em.createQuery("SELECT COUNT(ce) FROM ChannelEntity ce").getSingleResult();
    }
    
	@SuppressWarnings("unchecked")
	public List<ChannelEntity> findAll() {
    	return em.createQuery("FROM ChannelEntity ce").getResultList();
    }
	
	public List<ChannelEntity> findAllChannelsByBuild(BuildEntity buildEntity) {
		Query q = em.createQuery("SELECT ce FROM ChannelEntity ce WHERE ce.build = :pBuild");
		q.setParameter("pBuild", buildEntity);
		
		return q.getResultList();
	}
}
