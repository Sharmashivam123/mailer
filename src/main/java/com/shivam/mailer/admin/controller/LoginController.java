 	package com.shivam.mailer.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shivam.mailer.admin.dto.Credentials;
import com.shivam.mailer.admin.model.Principal;

@Controller
public class LoginController {

	
	@Autowired
	private Principal principal;
	
	@GetMapping("/admin")
	public ModelAndView login(Model model) {
		if(principal.getUsername()!=null)return new ModelAndView("redirect:/users");
		model.addAttribute(new Credentials());
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("credentials") Credentials credentials) {
		if(checkUsernameAndPassword(credentials)) {
			principal.setUsername(credentials.getUsername());
			principal.setPassword(credentials.getPassword());
			return new ModelAndView("redirect:/users");
		}
		return new ModelAndView("redirect:/index");
	}

	private boolean checkUsernameAndPassword(Credentials credentials) {
		if(credentials.getUsername().equals("username") && credentials.getPassword().equals("password"))
		{
			return true;
		}
		else 
		return false;
	}
	
}
