package com.redfern.springbootpostgresql1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redfern.springbootpostgresql1.model.Pet;
import com.redfern.springbootpostgresql1.repository.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> findAll() { 
		List<Pet> pets = petRepository.findAll();
		return pets;
	}
}
