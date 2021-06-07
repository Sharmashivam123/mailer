package com.shivam.mailer.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shivam.mailer.admin.model.Admin;
import com.shivam.mailer.repo.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> admin = adminRepository.findByUsername(username);
		return new MyUserDetails(admin.get());
	}

}
