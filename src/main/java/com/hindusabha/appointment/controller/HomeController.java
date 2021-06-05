package com.hindusabha.appointment.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hindusabha.appointment.utils.WebUtils;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "appointment/page-login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "appointment/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		
		return "appointment/page-login";
	}

	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "appointment/page-login";
	}

	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);
			

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "base/403Page";
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public String doctor(Model model) {
		return "appointment/forms-doctor";
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String department(Model model) {
		return "appointment/forms-department";
	}
	
	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public String appointment(Model model) {
		return "appointment/online-appointment";
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String feedback(Model model) {
		return "appointment/forms-feedback";
	}
	
	@RequestMapping(value = "/vaccination-feedback", method = RequestMethod.GET)
	public String vaccinationFeedback(Model model) {
		return "appointment/forms-vaccine";
	}
	
	@RequestMapping(value = "/vaccination-dashboard", method = RequestMethod.GET)
	public String vaccinationDashboard(Model model) {
		return "appointment/vaccination-dashboard";
	}
	
	@RequestMapping(value = "/ipd-dashboard", method = RequestMethod.GET)
	public String ipdDashboard(Model model) {
		return "appointment/ipd-dashboard";
	}

}
