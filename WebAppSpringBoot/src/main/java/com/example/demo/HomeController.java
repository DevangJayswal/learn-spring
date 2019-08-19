package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// in spring boot mvc we have embedded tomcat, so
// do not need to add server explicitly

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		String name = request.getParameter("nam");
		System.out.println("hi " + name);
		return "home";
	}
}
