package com.project.readandshare.business.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Genero;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Integer> {


	
}
