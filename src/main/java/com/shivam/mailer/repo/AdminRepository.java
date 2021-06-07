package com.shivam.mailer.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.shivam.mailer.admin.model.Admin;
public interface AdminRepository extends CrudRepository<Admin, Integer> {

	public Optional<Admin> findByUsername(String username);
	
}
