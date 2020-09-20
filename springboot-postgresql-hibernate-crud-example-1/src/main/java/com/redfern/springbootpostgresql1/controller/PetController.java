package com.redfern.springbootpostgresql1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.redfern.springbootpostgresql1.model.Pet;
import com.redfern.springbootpostgresql1.service.PetService;

@Controller
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping("/pets")
	public String getPets(Model model) {
		List<Pet> pets = petService.findAll();
		model.addAttribute("pets", pets);
		return "pet-list";
	}
}
