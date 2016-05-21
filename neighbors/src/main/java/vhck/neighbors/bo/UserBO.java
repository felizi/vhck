package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.UserDAO;
import vhck.neighbors.entity.UserEntity;

@Stateless
public class UserBO {

	@Inject private UserDAO userDAO;
	
	public void include(UserEntity user) {
		userDAO.include(user);
	}
	
	public void change(UserEntity user){
		userDAO.change(user);
	}
	
	public void remove(UserEntity user) {
		userDAO.remove(user);
	}
	
	public UserEntity findById(Long id) {
		return userDAO.findById(id);
	}
	
	public void removeById(Long id) {
		userDAO.removeById(id);
	}
	
	public Long countTotalOfUserRegistered() {
		return userDAO.count();
	}
	
	public List<UserEntity> findAll() {
		return userDAO.findAll();
	}
}
