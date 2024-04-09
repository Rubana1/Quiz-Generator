package com.login;

import java.util.HashMap;

public class LoginService {
	static HashMap<String,String> user =new HashMap(); 
	
	void createUser(String name, String pass) {
		user.put(name,pass);
	}
	
	String getUser(String name) {
		return user.get(name);
		
	}
}
