package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {

	// it will create object of AlienRepo which extends CrudRepository
	// then spring will instantiate CrudRepository so that we can make crud
	// operation
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	
	// when we have return type as String, it means that we are reurning the view
	// i.e JSP or any other view
	// but we in REST we are not concerned about view
	// we are returning a data, so we need to use @ResponseBody
	// to inform dispatcher servlet that we are not returning a view
	// we are returning an actual data
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		
		// findAll() returns Iterable 
		// but we have String return type
		// so we used toString() to convert
		return repo.findAll().toString();
		
		/* output will be List format in String (Not XML or JSON) */
	}
	
	
	@RequestMapping("/alien/102")
	@ResponseBody
	public String getAlien() {
		return repo.findById(102).toString();
		
	}

}
