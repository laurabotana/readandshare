package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Libro;
import com.project.readandshare.dto.ValoracionLibroDTO;


@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {
	
	@Query("SELECT d FROM Libro d WHERE d.id = :id")
	Libro consultarDetalleLibro(@Param("id") Integer c);

	@Query("SELECT l FROM Libro l WHERE l.autor.id = :id")
	List<Libro> consultarLibrosAutor(@Param("id") Integer c);
	
}
