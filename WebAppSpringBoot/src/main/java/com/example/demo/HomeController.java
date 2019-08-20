package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// in spring boot mvc we have embedded tomcat, so
// do not need to add server explicitly

@Controller
public class HomeController {

	@RequestMapping("home")
	public ModelAndView home(@RequestParam("nam") String myName) {		
		ModelAndView mv = new ModelAndView();
		mv.addObject("na", myName);
		mv.setViewName("home");
		
		return mv;
	}
}
