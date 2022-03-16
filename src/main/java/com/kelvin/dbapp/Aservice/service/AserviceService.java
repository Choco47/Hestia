package com.kelvin.dbapp.Aservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.Aservice.model.Aservice;
import com.kelvin.dbapp.Aservice.repository.AserviceRepository;


@Service
public class AserviceService {

	@Autowired AserviceRepository aserviceRepository;
	
	public List<Aservice> findAll(){
		return aserviceRepository.findAll();
	}
	
	public void save(Aservice aservice) {
		
		aserviceRepository.save(aservice);	
	}
	
	public void delete(Integer id) {
		aserviceRepository.deleteById(id);
	}
	
	public Aservice getById(Integer id) {
		return aserviceRepository.findById(id).orElse(null);
	}
	
}
