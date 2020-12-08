package com.theCode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(HttpSession session, RedirectAttributes errors) {
		//checks if nothing is in session, if so set default access to false
		if (session.getAttribute("access") == null) {
			session.setAttribute("access", false);
		}
		
		//render home page
		return "index.jsp";		
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String index_post(@RequestParam(value = "code_input") String code_input, RedirectAttributes errors, HttpSession session) {
		if(code_input.equals("bushido")) {
			//set access to true
			session.setAttribute("access", true);
			
			return "redirect:/code";
		}
		errors.addFlashAttribute("error", "You must train harder!");

		return "redirect:/";
	}
	
	@RequestMapping(value="/code", method = RequestMethod.GET)
	public String code(HttpSession session) {
		if(session.getAttribute("access").equals(false)) {
			return "redirect:/";
		}
		return "code.jsp";
	}
	
	@RequestMapping(value="/clear", method = RequestMethod.GET)
	public String clear(HttpSession session) {

		session.invalidate();
		
		return "redirect:/";
	}
}
