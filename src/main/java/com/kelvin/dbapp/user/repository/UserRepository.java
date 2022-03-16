package com.kelvin.dbapp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//spring security
	User findByUsername(String username);
	
}
