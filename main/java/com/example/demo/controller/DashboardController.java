package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {
	
	@RequestMapping("/dashboard")
    public ModelAndView dashboard() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("dashboard");
		return mav;
	}

}
