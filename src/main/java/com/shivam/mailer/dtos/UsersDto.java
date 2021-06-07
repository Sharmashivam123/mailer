package com.shivam.mailer.dtos;

import java.util.List;

import com.shivam.mailer.model.User;

public class UsersDto {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
