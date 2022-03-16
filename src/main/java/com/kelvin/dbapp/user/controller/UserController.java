package com.kelvin.dbapp.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.kelvin.dbapp.user.model.User;
import com.kelvin.dbapp.user.service.UserService;

@Controller
public class UserController {

	
	@Autowired
    private UserService userService;
 	//find all
	@GetMapping("/user")
	public String getAll(Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("user",userList);		
		return "user/userList";
	}
	
    //Return web page
	@GetMapping("/userAdd")
	public String addUser() {
	return "user/userAdd";
	}
	
	//Return page n get byId for UPDATE
	@GetMapping("/userEdit/{id}")
	public String EditUser(@PathVariable Integer id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
	return "user/userEdit";
	}
	
	//Return Detail page 
	@GetMapping("/userDetail/{id}")
	public String DetailUser(@PathVariable Integer id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("user", user);
	return "user/userDetail";
	}
	
	//ADD NEW
	@PostMapping("/user")
		public String save(User user) {
			userService.save(user);
			return "redirect:/user";	
	}
	//DELETE
	@RequestMapping (value="/user/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String delete(@PathVariable Integer id) {
		userService.delete(id);
		return "redirect:/user";	
	}
	
	//UPDATE
	@RequestMapping (value="/user/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(User user) {
		userService.save(user);
		return "redirect:/user";	
	}
	
	//
	@PostMapping(value="user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	        redir.addFlashAttribute("message",
	    		"You successfully registered! You can now login");
	    return redirectView;				
	}
	
}
