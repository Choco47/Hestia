package com.kelvin.dbapp.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.contact.model.Contact;
import com.kelvin.dbapp.contact.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired ContactRepository contactRepository;
	
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	public void save(Contact contact) {
		
		contactRepository.save(contact);	
	}
	
	public void delete(Integer id) {
		contactRepository.deleteById(id);
	}
	
	public Contact getById(Integer id) {
		return contactRepository.findById(id).orElse(null);
	}
	

	public void savepage(Contact contact) {
		
		contactRepository.save(contact);	
	}
}
