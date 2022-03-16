package com.kelvin.dbapp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.user.model.User;
import com.kelvin.dbapp.user.repository.UserRepository;




@Service
public class UserService {

	@Autowired UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public void save(User user) {
		
		userRepository.save(user);	
	}
	
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User getById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	

	
	
}
