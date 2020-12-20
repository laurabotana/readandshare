package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Genero;

@Repository
public interface GeneroRepository extends CrudRepository<Genero, Integer> {

	@Query("SELECT g FROM Genero g")
	List<Genero> consultarGeneros();
	
	@Query("SELECT g FROM Genero g WHERE g.id = :idGenero")
	Genero consultarGenero(@Param("idGenero") Integer idGenero);
	
}
