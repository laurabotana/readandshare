package com.project.readandshare.business.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Autor;
import com.project.readandshare.business.model.LibroGenero;


@Repository
public interface LibroGeneroRepository extends CrudRepository<LibroGenero, Integer> {

	@Query("SELECT l FROM LibroGenero l WHERE l.id_libro.id = :idLibro")
	LibroGenero consultarLibroGenero(@Param("idLibro") Integer idLibro);

	
}
