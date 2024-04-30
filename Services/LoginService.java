package Services;

import models.Login;

public class LoginService {
	private static final String username = "user";
	private static final String password = "password";
	
	public boolean authenticate(Login login) {
		// logics
		return login.getUsername().equals(username)&& login.getPassword().equals(password);
	}

}
