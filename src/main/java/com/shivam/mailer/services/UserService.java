package com.shivam.mailer.services;

import java.util.List;

import com.shivam.mailer.model.User;

public interface UserService {

	public User saveUser(User user);

	public User getUserByEmail(String emailId);
	
	public List<User> getUsers();
}
