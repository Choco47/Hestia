package com.kelvin.dbapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	
	//main
	@GetMapping("/")
	public String hestia() {		return "main/index"; }
	
	@GetMapping("/index")
	public String indexx() {		return "main/index"; }
	
	@GetMapping("/about")
	public String about() {			return "main/about"; }
	
	@GetMapping("/contactpage")
	public String contactpage() {	return "main/contactpage"; }
	
	//@GetMapping("/productpage")
	//public String productpage() {	return "main/productpage"; }
	
	//@GetMapping("/service")
	//public String service() {		return "main/service"; }
	
	@GetMapping("/admin")
	public String admin() {			return "main/admin"; }
	
	@GetMapping("/login")
	public String login() {			return "login"; }
	
	@GetMapping("/logout")
	public String logout() {		return "login"; }
	
	@GetMapping("/register")
	public String register() {		return "register"; }
	
	//test
	@GetMapping("/hestia")
	public String index() {			return "index"; }
	//layout
	@GetMapping("/layout")
	public String _layout() {		return "_layout"; }
}
