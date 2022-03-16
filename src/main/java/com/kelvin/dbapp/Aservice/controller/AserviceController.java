package com.kelvin.dbapp.Aservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.dbapp.Aservice.model.Aservice;
import com.kelvin.dbapp.Aservice.service.AserviceService;

@Controller
public class AserviceController {
	
	@Autowired
    private AserviceService aserviceService;
	
	@GetMapping("/service")
	public String page(Model model){
		List<Aservice> aserviceList = aserviceService.findAll();
		model.addAttribute("aservice",aserviceList);		
		return "main/service";
	}
	
	
	
	
	//find all
		@GetMapping("/aservice")
		public String getAll(Model model){
			List<Aservice> aserviceList = aserviceService.findAll();
			model.addAttribute("aservice",aserviceList);		
			return "aservice/aserviceList";
		}
		
	    //Return web page
		@GetMapping("/aserviceAdd")
		public String addAservice() {
		return "aservice/aserviceAdd";
		}
		
		//Return page n get byId for UPDATE
		@GetMapping("/aserviceEdit/{id}")
		public String EditAservice(@PathVariable Integer id, Model model) {
			Aservice aservice = aserviceService.getById(id);
			model.addAttribute("aservice", aservice);
		return "aservice/aserviceEdit";
		}
		
		//Return Detail page 
		@GetMapping("/aserviceDetail/{id}")
		public String DetailAservice(@PathVariable Integer id, Model model) {
			Aservice aservice = aserviceService.getById(id);
			model.addAttribute("aservice", aservice);
		return "aservice/aserviceDetail";
		}
		
		//ADD NEW
		@PostMapping("/aservice")
			public String save(Aservice aservice) {
				aserviceService.save(aservice);
				return "redirect:/aservice";	
		}
		//DELETE
		@RequestMapping (value="/aservice/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
		public String delete(@PathVariable Integer id) {
			aserviceService.delete(id);
			return "redirect:/aservice";	
		}
		
		//UPDATE
		@RequestMapping (value="/aservice/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
		public String update(Aservice aservice) {
			aserviceService.save(aservice);
			return "redirect:/aservice";	
		}

}
