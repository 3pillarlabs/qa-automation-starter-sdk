package com.tpg.quality.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSampleController {
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping(value="/registerationSuccess", method=RequestMethod.POST)
	public ModelAndView afterRegisteration(@RequestParam("uname") String name, HttpServletRequest request ) {

		HttpSession session = request.getSession();
		session.setAttribute("uname", name);
		ModelAndView model = new ModelAndView("registered");
		model.addObject("uname", name);
		return model;

	}

	@RequestMapping("/welcome")
	public ModelAndView loginPage(){
		ModelAndView model = new ModelAndView("welcome");
		return model;
	}

	@RequestMapping("/registeration")
	public ModelAndView registerationPage(HttpServletRequest request , HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("uname", null);
		ModelAndView model1 = new ModelAndView("registeration");
		return model1;		
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("uname") String name, HttpServletRequest request, HttpServletResponse response ) {
		HttpSession session = request.getSession();
		String myUsername = (String)session.getAttribute("uname");
		if (myUsername.equals(name)){
			ModelAndView model = new ModelAndView("success");

			model.addObject("uname", name);
			return model;
		}
		else {
			ModelAndView model = new ModelAndView("error");
			return model;

		}
	}

}