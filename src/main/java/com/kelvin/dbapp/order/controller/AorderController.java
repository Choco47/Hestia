package com.kelvin.dbapp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.dbapp.Aservice.service.AserviceService;
import com.kelvin.dbapp.order.model.Aorder;
import com.kelvin.dbapp.order.service.AaorderService;


@Controller
public class AorderController {
	
	@Autowired
    private AaorderService aorderService;
	@Autowired
    private AserviceService aserviceService;
	
	
	@PostMapping("/servicepage")
	public String savepage(Aorder aorder) {
		aorderService.save(aorder);
		return "redirect:/service";	
	}
	
	@GetMapping("/serive")
	public String addOrderpage(Model model){
		model.addAttribute("aorder", aorderService.findAll());
		model.addAttribute("aservice", aserviceService.findAll());
		return "redirect:/service";
	}
	
	
	
	
	//---------------------------------

	//Get All Order
	@GetMapping("/aorder")
	public String findAll(Model model){
		model.addAttribute("aorder", aorderService.findAll());
		model.addAttribute("aservice", aserviceService.findAll());
		return "aorder/aorderlist";
	}

	@GetMapping("/aorderAdd")
	public String addOrder(Model model){
		model.addAttribute("aorder", aorderService.findAll());
		model.addAttribute("aservice", aserviceService.findAll());
		return "aorder/aorderAdd";
	}
	
	@GetMapping("/aorderEdit/{id}" )
	public String editOrder(@PathVariable Integer id, Model model){
		model.addAttribute("aorder", aorderService.findAll());
		model.addAttribute("aservice", aserviceService.findAll());
		model.addAttribute("aorder", aorderService.findById(id));
		return "aorder/aorderEdit";
	}
	
	@GetMapping("/aorderDetail/{id}" )
	public String DeatilOrder(@PathVariable Integer id, Model model){
		model.addAttribute("aorder", aorderService.findAll());
		model.addAttribute("aservice", aserviceService.findAll());
		model.addAttribute("aorder", aorderService.findById(id));
		return "aorder/aorderDetail";
	}
	

	//Add Order
	@PostMapping("/aorder")
	public String addNew(Aorder aorder) {
		aorderService.save(aorder);
		return "redirect:/aorder";
	}
	
	@RequestMapping (value="/aorder/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Aorder aorder) {
		aorderService.save(aorder);
		return "redirect:/aorder";	
	}

	@RequestMapping(value="/aorder/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		aorderService.delete(id);
		return "redirect:/aorder";
	}

}
