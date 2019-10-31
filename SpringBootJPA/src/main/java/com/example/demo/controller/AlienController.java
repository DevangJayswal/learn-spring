package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
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

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid)
	{
	 	Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
//	@PutMapping(path="/alien", consumes="application/json")
//	public Alien saveOrUpdateAlien(Alien alien) {
//		repo.save(alien);
//		return alien;
//	}
	
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	
	@PostMapping("/alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		System.out.println("aliens saved");
		return alien;
	}
	
	
	

	@GetMapping("/aliens")
	public List<Alien> getAliens() {
		return (List<Alien>) repo.findAll();
	}

	@RequestMapping("/alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
}
