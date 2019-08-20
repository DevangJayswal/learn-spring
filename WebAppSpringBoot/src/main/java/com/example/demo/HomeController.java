package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// in spring boot mvc we have embedded tomcat, so
// do not need to add server explicitly

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home(@RequestParam("nam") String myName, HttpSession session) {		
		session.setAttribute("na", myName);
		System.out.println("hi " + myName);
		return "home";
	}
}
