package com.flightReservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.entities.User;
import com.flightReservation.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("inside showLoginPage() ");
		return "login/login";
	}
	@RequestMapping("/showReg")
public String showRegistrationPage() {
		LOGGER.info("inside showRegistrationPage()");
	return "login/registerUser";
}
	//@RequestMapping(value = "registerUser",method = RequestMethod.POST)
	@RequestMapping("/registerUser")
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("inside register() "+user);
		userRepository.save(user);
		return "login/login";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password") 
	String password,ModelMap modelMap) {
		/*
		 * LOGGER.error("ERROR"); LOGGER.warn("WARN"); LOGGER.info("INFO");
		 * LOGGER.debug("DEBUG"); LOGGER.trace("TRACE");
		 */
		LOGGER.info("inside login() and email is"+email);
		User user = userRepository.findByEmail(email);
		if(user.getPassword().equals(password)) {
			return "login/findFlight";
		}else {
			modelMap.addAttribute("msg","invalid user name or password.Please try again");
		}
		return "login/login";
	}
}
