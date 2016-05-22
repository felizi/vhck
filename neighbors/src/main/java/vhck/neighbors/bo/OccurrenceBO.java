package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.OccurrenceDAO;
import vhck.neighbors.entity.OccurrenceEntity;

@Stateless
public class OccurrenceBO {

	@Inject
	private OccurrenceDAO occurrenceDAO;

	public void include(OccurrenceEntity occurrence) {
		occurrenceDAO.include(occurrence);
	}

	public void change(OccurrenceEntity occurrence) {
		occurrenceDAO.change(occurrence);
	}

	public void remove(OccurrenceEntity occurrence) {
		occurrenceDAO.remove(occurrence);
	}

	public OccurrenceEntity findById(Long id) {
		return occurrenceDAO.findById(id);
	}

	public void removeById(Long id) {
		occurrenceDAO.removeById(id);
	}

	public Long count() {
		return occurrenceDAO.count();
	}

	public List<OccurrenceEntity> findAll() {
		return occurrenceDAO.findAll();
	}
}