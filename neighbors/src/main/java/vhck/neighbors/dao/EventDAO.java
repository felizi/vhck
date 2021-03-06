package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import vhck.neighbors.entity.EventEntity;

@Stateless
public class EventDAO extends Persistence {

	public void include(EventEntity eventEntity) {
		em.persist(eventEntity);
	}

	public EventEntity change(EventEntity eventEntity) {
		return em.merge(eventEntity);
	}

	public void remove(EventEntity eventEntity) {
		em.remove(em.merge(eventEntity));
	}

	public EventEntity findById(Long id) {
		return em.find(EventEntity.class, id);
	}

	public void removeById(Long id) {
		em.remove(this.findById(id));
	}

	public Long count() {
		return (Long) em.createQuery("SELECT COUNT(ee) FROM EventEntity ee").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<EventEntity> findAll() {
		return em.createQuery("FROM EventEntity ee").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<EventEntity> findByBuilding(Long buildingId) {
		Query q = em.createQuery("FROM EventEntity ee WHERE ee.build.id = :buildingId");
		q.setParameter("buildingId", buildingId);

		return q.getResultList();
	}
}
