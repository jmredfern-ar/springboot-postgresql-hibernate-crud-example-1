package com.redfern.springbootpostgresql1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfern.springbootpostgresql1.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
