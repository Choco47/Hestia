package com.kelvin.dbapp.newsletter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.dbapp.newsletter.model.Newsletter;
import com.kelvin.dbapp.newsletter.service.NewsletterService;

@Controller
public class NewsletterController {

	
	@Autowired
    private NewsletterService newsletterService;
 	//find all
	@GetMapping("/newsletter")
	public String getAll(Model model){
		List<Newsletter> newsletterList = newsletterService.findAll();
		model.addAttribute("newsletter",newsletterList);		
		return "newsletter/newsletterList";
	}
	
    //Return web page
	@GetMapping("/newsletterAdd")
	public String addNewsletter() {
	return "newsletter/newsletterAdd";
	}
	
	//Return page n get byId for UPDATE
	@GetMapping("/newsletterEdit/{id}")
	public String EditNewsletter(@PathVariable Integer id, Model model) {
		Newsletter newsletter = newsletterService.getById(id);
		model.addAttribute("newsletter", newsletter);
	return "newsletter/newsletterEdit";
	}
	
	//Return Detail page 
	@GetMapping("/newsletterDetail/{id}")
	public String DetailNewsletter(@PathVariable Integer id, Model model) {
		Newsletter newsletter = newsletterService.getById(id);
		model.addAttribute("newsletter", newsletter);
	return "newsletter/newsletterDetail";
	}
	
	//ADD NEW
	@PostMapping("/newsletter")
		public String save(Newsletter newsletter) {
			newsletterService.save(newsletter);
			return "main/index";	
	}
	//DELETE
	@RequestMapping (value="/newsletter/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		newsletterService.delete(id);
		return "redirect:/newsletter";	
	}
	
	//UPDATE
	@RequestMapping (value="/newsletter/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Newsletter newsletter) {
		newsletterService.save(newsletter);
		return "redirect:/newsletter";	
	}
	
	
	
}
