package vhck.neighbors.bo;

import javax.inject.Inject;

import com.google.common.base.Preconditions;

import vhck.neighbors.entity.UserEntity;
import vhck.neighbors.exception.PasswordInvalidException;
import vhck.neighbors.exception.UserNotFoundException;
import vhck.neighbors.utilities.Encryptor;

public class AuthBO {

	@Inject
	private UserBO userBO;

	public UserEntity authenticate(String email, String password) throws PasswordInvalidException, UserNotFoundException, IllegalArgumentException, NullPointerException {
		Preconditions.checkNotNull(email);
		Preconditions.checkNotNull(password);
		Preconditions.checkArgument(!email.isEmpty());
		Preconditions.checkArgument(!password.isEmpty());

		UserEntity user = null;
		password = Encryptor.encryptForMD5(password);
		user = userBO.findByEmail(email);
		if (user == null) {
			throw new UserNotFoundException();
		}
		if (!user.getPassword().equals(password)) {
			throw new PasswordInvalidException();
		}

		return user;
	}
}
