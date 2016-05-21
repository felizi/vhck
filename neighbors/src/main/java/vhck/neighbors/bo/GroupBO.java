package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.GroupDAO;
import vhck.neighbors.entity.GroupEntity;

@Stateless
public class GroupBO {

	@Inject private GroupDAO groupDAO;
	
	public void include(GroupEntity group) {
		groupDAO.include(group);
	}
	
	public void change(GroupEntity group){
		groupDAO.change(group);
	}
	
	public void remove(GroupEntity group) {
		groupDAO.remove(group);
	}
	
	public GroupEntity findById(Long id) {
		return groupDAO.findById(id);
	}
	
	public void removeById(Long id) {
		groupDAO.removeById(id);
	}
	
	public Long countTotalOfGroupRegistered() {
		return groupDAO.count();
	}
	
	public List<GroupEntity> findAll() {
		return groupDAO.findAll();
	}
}
