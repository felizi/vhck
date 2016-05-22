package vhck.neighbors.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import vhck.neighbors.entity.OccurrenceEntity;

@Stateless
public class OccurrenceDAO extends Persistence {

	public void include(OccurrenceEntity occurrenceEntity) {
		em.persist(occurrenceEntity);
	}

	public OccurrenceEntity change(OccurrenceEntity occurrenceEntity) {
		return em.merge(occurrenceEntity);
	}

	public void remove(OccurrenceEntity occurrenceEntity) {
		em.remove(em.merge(occurrenceEntity));
	}

	public OccurrenceEntity findById(Long id) {
		return em.find(OccurrenceEntity.class, id);
	}

	public void removeById(Long id) {
		em.remove(this.findById(id));
	}

	public Long count() {
		return (Long) em.createQuery("SELECT COUNT(ee) FROM OccurrenceEntity oe").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<OccurrenceEntity> findAll() {
		return em.createQuery("FROM OccurrenceEntity oe").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<OccurrenceEntity> findByBuilding(Long buildingId) {
		Query q = em.createQuery("FROM OccurrenceEntity oe WHERE oe.build.id = :buildingId");
		q.setParameter("buildingId", buildingId);

		return q.getResultList();
	}
}
