package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.entity.UserEntity;

@Stateless
public class UserDAO extends Persistence{
	
	public void include(UserEntity userEntity) {
        em.persist(userEntity);
    }
 
    public UserEntity change(UserEntity userEntity) {
        return em.merge(userEntity);
    }
 
    public void remove(UserEntity userEntity) {
        em.remove(em.merge(userEntity));
    }
	
    public UserEntity findById(Long id) {
        return em.find(UserEntity.class, id);
    }	
 
    public void removeById(Long id) {
        em.remove(this.findById(id));
    }
 
    public Long count() {
		return (Long) em.createQuery("SELECT COUNT(ue) FROM UserEntity ue").getSingleResult();
    }
    
	@SuppressWarnings("unchecked")
	public List<UserEntity> findAll() {
    	return em.createQuery("FROM UserEntity ue").getResultList();
    }
	
	public UserEntity findByEmail(String email) {
		try{
	        Query q = em.createQuery("SELECT ue FROM UserEntity ue WHERE ue.email = :pEmail");
	        q.setParameter("pEmail", email);
	        
	        return (UserEntity) q.getSingleResult();
    	} catch (NoResultException nre) {
            return null;
        }
    }
	
	public List<UserEntity> findAllUserByBuild(BuildEntity buildEntity) {
		Query q = em.createQuery("SELECT ube.user FROM UserBuildEntity ube WHERE ube.build = :pBuild");
		q.setParameter("pBuild", buildEntity);
		
		return q.getResultList();
	}
	
	public List<UserEntity> findAllUserLandlordOfBuild(BuildEntity buildEntity) {
		Query q = em.createQuery("SELECT ube.user FROM UserBuildEntity ube "
				+ "WHERE ube.build = :pBuild "
				+ "AND ube.landlord = :pLandLord ");
		
		q.setParameter("pBuild", buildEntity);
		q.setParameter("pLandLord", Boolean.TRUE);
		
		return q.getResultList();
	}
}

