package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.BuildDAO;
import vhck.neighbors.entity.BuildEntity;


@Stateless
public class BuildBO {

	@Inject private BuildDAO buildDAO;
	
	public void include(BuildEntity build) {
		buildDAO.include(build);
	}
	
	public void change(BuildEntity build){
		buildDAO.change(build);
	}
	
	public void remove(BuildEntity build) {
		buildDAO.remove(build);
	}
	
	public BuildEntity findById(Long id) {
		return buildDAO.findById(id);
	}
	
	public void removeById(Long id) {
		buildDAO.removeById(id);
	}
	
	public Long countTotalOfBuildRegistered() {
		return buildDAO.count();
	}
	
	public List<BuildEntity> findAll() {
		return buildDAO.findAll();
	}
}
