package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

	@Query("SELECT a FROM Autor a ORDER BY a.nombre ASC")
	List<Autor> consultarAutores();

	@Query("SELECT a FROM Autor a WHERE a.id = :idAutor")
	Autor consultarAutor(@Param("idAutor") Integer idAutor);


	
}
