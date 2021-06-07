package com.shivam.mailer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shivam.mailer.admin.model.Principal;
import com.shivam.mailer.dtos.UsersDto;
import com.shivam.mailer.exceptions.exceptiontypes.UserNotFoundException;
import com.shivam.mailer.model.User;
import com.shivam.mailer.services.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Principal principal;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping("/users")
	public ModelAndView getUsers(){
		if(principal.getUsername()==null) {
			return new ModelAndView("redirect:/index");
		}
		UsersDto userDto = new  UsersDto();
		List<User> list = userService.getUsers();
		userDto.setUsers(list);
		ModelAndView modeAndView = new ModelAndView();
		modeAndView.addObject("userdto", userDto);
		modeAndView.setViewName("users");
		return modeAndView;
	}
	
	@PostMapping("/register")
	public ModelAndView saveUser(@ModelAttribute("user") User user){
		User savedUser = userService.saveUser(user);
		if(savedUser==null ||  savedUser.getUserId()<0) {
			throw new UserNotFoundException("User Not Saved in the database");
		}
		return new ModelAndView("redirect:/index");
	}
	
	@PutMapping("/update")
	public ModelAndView updateUser(@ModelAttribute("user") User user){
		User registeredUser = userService.getUserByEmail(user.getEmailId());
		if(registeredUser==null)
		{
			throw new UserNotFoundException("No user is registered with this mailId "+user.getEmailId());
		}
		registeredUser.setFirstName(user.getFirstName());
		registeredUser.setLastName(user.getFirstName());
		userService.saveUser(registeredUser);
		return new ModelAndView("redirect:/index");
	}
}
