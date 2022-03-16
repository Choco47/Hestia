package com.kelvin.dbapp.newsletter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.newsletter.model.Newsletter;
import com.kelvin.dbapp.newsletter.repository.NewsletterRepository;

@Service
public class NewsletterService {

	
	@Autowired NewsletterRepository newsletterRepository;
	
	public List<Newsletter> findAll(){
		return newsletterRepository.findAll();
	}
	
	public void save(Newsletter newsletter) {
		
		newsletterRepository.save(newsletter);	
	}
	
	public void delete(Integer id) {
		newsletterRepository.deleteById(id);
	}
	
	public Newsletter getById(Integer id) {
		return newsletterRepository.findById(id).orElse(null);
	}
	
}
