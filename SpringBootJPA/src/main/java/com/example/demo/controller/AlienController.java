package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		System.out.println("in get alien");
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		
		// orElse and Optional is feature of JAVA 8
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		System.out.println("before returning mv");
		return mv;
	} 

}
