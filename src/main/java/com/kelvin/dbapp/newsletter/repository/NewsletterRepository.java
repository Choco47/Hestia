package com.kelvin.dbapp.newsletter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.newsletter.model.Newsletter;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {
	

	
}
