package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class DummyController {

	@RequestMapping("/hello")//only we use it then actual jsp dispalays
//	@ResponseBody//returned value directly to the browser ot to view
	public String hello() {
		return "welcome";
	}
}
