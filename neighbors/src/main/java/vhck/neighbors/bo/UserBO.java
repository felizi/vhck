package vhck.neighbors.bo;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import vhck.neighbors.dao.UserDAO;
import vhck.neighbors.entity.BuildEntity;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.EmailAlreadyRegisteredException;

@Stateless
public class UserBO {

	@Inject private UserDAO userDAO;
	
	public void include(UserEntity user) throws EmailAlreadyRegisteredException {
		if(this.findByEmail(user.getEmail()) == null) {
			userDAO.include(user);
		} else {
			throw new EmailAlreadyRegisteredException();
		}
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
	
	public UserEntity findByEmail(String email){
		return userDAO.findByEmail(email);
	}
	
	public List<UserEntity> findAllUserByBuild(BuildEntity buildEntity) {
		return userDAO.findAllUserByBuild(buildEntity);
	}
}
