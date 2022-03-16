package com.kelvin.dbapp.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelvin.dbapp.contact.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
