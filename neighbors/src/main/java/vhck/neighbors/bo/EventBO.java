package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.EventDAO;
import vhck.neighbors.entity.EventEntity;

@Stateless
public class EventBO {

	@Inject private EventDAO eventDAO;
	
	public void include(EventEntity event) {
		eventDAO.include(event);
	}
	
	public void change(EventEntity event){
		eventDAO.change(event);
	}
	
	public void remove(EventEntity event) {
		eventDAO.remove(event);
	}
	
	public EventEntity findById(Long id) {
		return eventDAO.findById(id);
	}
	
	public void removeById(Long id) {
		eventDAO.removeById(id);
	}
	
	public Long countTotalOfEventRegistered() {
		return eventDAO.count();
	}
	
	public List<EventEntity> findAll() {
		return eventDAO.findAll();
	}
}
