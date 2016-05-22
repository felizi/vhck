package vhck.neighbors.dto;

public class LoginPasswordDTO {
	private String login;
	private String password;

	public LoginPasswordDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

}
