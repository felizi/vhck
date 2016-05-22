package vhck.neighbors.jersey.translator;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vhck.neighbors.dto.LoginPasswordDTO;
import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.jersey.translator.constants.BasicConstants;

public class UserTranslator {
	public UserEntity createUser(String contentRequest) {
		Map<Object, Object> userMap = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {
		}.getType());

		String name = (String) userMap.get(BasicConstants.NAME);
		String email = (String) userMap.get(BasicConstants.EMAIL);
		String password = (String) userMap.get(BasicConstants.PASSWORD);

		UserEntity userEntity = new UserEntity(name, email);
		userEntity.setPassword(password);

		return userEntity;
	}

	public LoginPasswordDTO convertJsonAuth(String contentRequest) {
		Map<Object, Object> authMap = new Gson().fromJson(contentRequest, new TypeToken<HashMap<Object, Object>>() {
		}.getType());

		String email = (String) authMap.get(BasicConstants.EMAIL);
		String password = (String) authMap.get(BasicConstants.PASSWORD);

		return new LoginPasswordDTO(email, password);
	}
}
