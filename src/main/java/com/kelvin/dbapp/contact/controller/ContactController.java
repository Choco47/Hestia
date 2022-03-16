package com.kelvin.dbapp.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kelvin.dbapp.contact.model.Contact;
import com.kelvin.dbapp.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
    private ContactService contactService;
	
	@PostMapping("/contactpage")
	public String savepage(Contact contact) {
		contactService.savepage(contact);
		return "main/contactpage";	
	}
	
	//----------------------
 	//find all
	@GetMapping("/contact")
	public String getAll(Model model){
		List<Contact> contactList = contactService.findAll();
		model.addAttribute("contact",contactList);		
		return "contact/contactList";
	}
	
    //Return web page
	@GetMapping("/contactAdd")
	public String addContact() {
	return "contact/contactAdd";
	}
	
	//Return page n get byId for UPDATE
	@GetMapping("/contactEdit/{id}")
	public String EditContact(@PathVariable Integer id, Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact", contact);
	return "contact/contactEdit";
	}
	
	//Return Detail page 
	@GetMapping("/contactDetail/{id}")
	public String DetailContact(@PathVariable Integer id, Model model) {
		Contact contact = contactService.getById(id);
		model.addAttribute("contact", contact);
	return "contact/contactDetail";
	}
	
	//ADD NEW
	@PostMapping("/contact")
		public String save(Contact contact) {
			contactService.save(contact);
			return "redirect:/contact";	
	}
	//DELETE
	@RequestMapping (value="/contact/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		contactService.delete(id);
		return "redirect:/contact";	
	}
	
	//UPDATE
	@RequestMapping (value="/contact/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(Contact contact) {
		contactService.save(contact);
		return "redirect:/contact";	
	}
	
}
