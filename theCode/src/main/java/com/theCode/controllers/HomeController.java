package com.theCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String index_post(@RequestParam(value = "code_input") String code_input, RedirectAttributes errors) {
		if(code_input.equals("bushido")) {
			return "redirect:/code";
		}
		errors.addFlashAttribute("error", "You must train harder!");

		return "redirect:/";
	}
	
	@RequestMapping(value="/code", method = RequestMethod.GET)
	public String code() {
		return "code.jsp";
	}
}
