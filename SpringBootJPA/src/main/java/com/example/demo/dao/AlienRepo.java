package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

// Alien --> responsible to work with Alien
// Integer --> primary key is type of integer 

// we are not implementing AlienRepo anywhere, Spring Data Rest is responsible for that
public interface AlienRepo extends JpaRepository<Alien,Integer>, CrudRepository<Alien, Integer> {

}
