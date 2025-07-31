package com.springsecurity.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springsecurity.DAO.ChangePasswordDTO;
import com.springsecurity.DAO.SignUpDAO;
import com.springsecurity.DTO.SignUpDTO;

@Controller
public class logInController {
	@Autowired
	SignUpDAO signUpDAO;
	
	@GetMapping("/customLogInPage")
	public String LogInPage() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String SignUpPage(@ModelAttribute("signup") SignUpDTO signupDTO) {
		return "signup";
	}
	
	@PostMapping("/process-signup")
	public String ProcessSignUpPage(SignUpDTO signupDTO) {
		signUpDAO.addUser(signupDTO);
		return "redirect: customLogInPage";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("username") String username)
	{
		signUpDAO.deleteUser(username);
		return "redirect: customLogInPage";
	}
	
	
	@GetMapping("/changePassword")
	public String changePassword(@RequestParam("username") String username ,  ChangePasswordDTO model)
	{
		return "changePassword";
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	
	
	@GetMapping("/process-password")
	public String processPassword( @ModelAttribute("model") ChangePasswordDTO model, Principal principal)
	{
		UserDetails userDetails = signUpDAO.GetUser(principal.getName());
		if(model.getOldPassword().equals(userDetails.getPassword())) {
			signUpDAO.changePassword(model.getOldPassword(), model.getNewPassword());
			return "redirect: home";
		}else {
			return "changePassword";
		}
	}
}
