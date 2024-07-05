package com.jspiders.springmvc1.controller;

import java.nio.file.Path;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.dto.UserDTO;
import com.jspiders.springmvc1.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/sign_up",method = RequestMethod.GET)
	public String getSignUpPage() {
		
		return "sign_up";
	}
	
	@RequestMapping(path = "/add_user",method = RequestMethod.POST )
	public String addUser(@RequestParam(name="email") String email, @RequestParam(name="password") String password ,ModelMap modelMap) {

        userService.addUser( email, password);
		modelMap.addAttribute("message", "signed up");
		return "sign_in";
	}
	
	@RequestMapping(path = "/sign_in",method=RequestMethod.GET)
	public String getSignInPage() {
		return "sign_in";
	}
	
	@RequestMapping(path = "/check_user" ,method = RequestMethod.POST)
	public String checkUser(@RequestParam(name="email") String email,@RequestParam(name="password") String password,ModelMap modelMap,HttpSession httpSession) {
		
		UserDTO foundUser=userService.checkUser(email,password);

		if(foundUser!=null) {
			httpSession.setAttribute("user", foundUser);
			httpSession.setMaxInactiveInterval(600);
			return "home";
		}
		else {
			modelMap.addAttribute("message", "email Or password Invalid");
			return "sign_in";
		}
		
	}
	@RequestMapping(path ="sign_out",method = RequestMethod.GET)	
	public String  signOut(ModelMap modelMap,HttpSession httpSession) {
		modelMap.addAttribute("message", "Signed Out");
		httpSession.invalidate();
		return "sign_in";
	}
		

	
}
