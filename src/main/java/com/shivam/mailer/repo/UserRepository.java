package com.shivam.mailer.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shivam.mailer.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	public User getUserByEmailId(String emailId);

}
