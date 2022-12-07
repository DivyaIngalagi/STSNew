package com.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Customer;

@Controller
public class CustomerController {

//	@Value("${customer.name}")
//String personname;	
	
	@GetMapping("/hello")
	public String getPage(Model model)
	{
		Customer customer=new Customer();
	   model.addAttribute("custObj",customer);
//	   System.out.println(personname);
		
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)	
	public ModelAndView loadForm(@ModelAttribute("custObj") Customer customer)
	{
		System.out.println(customer.getCustName());
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("customer", customer);
		  mv.setViewName("welcomepage");
		 
		
		
		return mv;
		
		
	}
}
