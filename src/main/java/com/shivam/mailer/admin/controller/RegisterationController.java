//package com.shivam.mailer.admin.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.shivam.mailer.admin.dto.AdminRegisterationDto;
//
//@Controller
//@RequestMapping("/admin/register")
//public class RegisterationController {
//
//	@GetMapping
//	public String getRegisterationPage(Model model) {
//		AdminRegisterationDto admin = new AdminRegisterationDto();
//		model.addAttribute("admin", admin);
//		return "adminregister";
//	}
//	
//	@PostMapping
//	public ModelAndView saveRegisteredUser(@ModelAttribute("admin") AdminRegisterationDto admin) {
//		
//	}
//	
//}
