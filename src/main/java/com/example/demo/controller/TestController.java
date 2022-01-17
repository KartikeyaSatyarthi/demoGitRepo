package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/a")
	public ModelAndView sayHello() {
		
	//	theModel.addAttribute("theDate", new java.util.Date());
		
		ModelAndView mnv=new ModelAndView();
		mnv.setViewName("helloworld");
		return mnv;
	}
}
