package com.kelvin.dbapp.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.user.model.User;
import com.kelvin.dbapp.user.model.UserPrincipal;
import com.kelvin.dbapp.user.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
					//user principal is a wrapper for user provide other method
		return new UserPrincipal(user);
	}
	
}
