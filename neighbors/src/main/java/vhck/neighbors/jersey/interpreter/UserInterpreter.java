package vhck.neighbors.jersey.interpreter;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vhck.neighbors.bo.AuthBO;
import vhck.neighbors.bo.UserBO;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.EmailAlreadyRegisteredException;
import vhck.neighbors.exception.PasswordInvalidException;
import vhck.neighbors.exception.UserNotFoundException;

@Named
public class UserInterpreter {

	@Inject private UserBO userBO;
	@Inject private AuthBO authBO;
	
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	public UserEntity createUser(String contentRequest) throws EmailAlreadyRegisteredException {
		Map<Object, Object> userMap = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {}.getType());
		
		String name = (String) userMap.get(NAME);
		String email = (String) userMap.get(EMAIL);
		String password = (String) userMap.get(PASSWORD);
		
		UserEntity userEntity = new UserEntity(name, email);
		userEntity.setPassword(password);
		
		userBO.include(userEntity);
		
		return userEntity;
	}
	
	public void authenticate(String contentRequest) throws PasswordInvalidException, UserNotFoundException {
		Map<Object, Object> authMap = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {}.getType());
		
		String email = (String) authMap.get(EMAIL);
		String password = (String) authMap.get(PASSWORD);
		
		authBO.authenticate(email, password);
	}
}

