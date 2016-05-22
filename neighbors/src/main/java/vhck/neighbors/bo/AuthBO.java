package vhck.neighbors.bo;

import javax.inject.Inject;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.PasswordInvalidException;
import vhck.neighbors.exception.UserNotFoundException;
import vhck.neighbors.utilities.Encryptor;

public class AuthBO {

	@Inject private UserBO userBO;

	public UserEntity authenticate(String email, String password) throws PasswordInvalidException, UserNotFoundException {
    	UserEntity user = null;
    	
    	if (password != null && !password.isEmpty()) {
    		password = Encryptor.encryptForMD5(password);
        }
        if (email != null && !email.isEmpty()) {
			user = userBO.findByEmail(email);
			if (!user.getPassword().equals(password)) {
        		throw new PasswordInvalidException();
            }
        }
    	
    	return user;
    }
}
