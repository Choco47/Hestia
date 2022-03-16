package com.kelvin.dbapp.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelvin.dbapp.order.model.Aorder;
import com.kelvin.dbapp.order.repository.AorderRepository;



@Service
public class AaorderService {

	@Autowired AorderRepository aorderRepository;
	
	public List<Aorder> findAll(){
		return aorderRepository.findAll();
	}
	
	public void save(Aorder aorder) {
		
		aorderRepository.save(aorder);	
	}
	
	public void delete(Integer id) {
		aorderRepository.deleteById(id);
	}
	
	public Aorder findById(Integer id) {
		return aorderRepository.findById(id).orElse(null);
	}
	
}
