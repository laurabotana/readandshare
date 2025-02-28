package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Libro;


@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {
	
	@Query("SELECT l FROM Libro l WHERE l.id = :idLibro")
	Libro consultarDetalleLibro(@Param("idLibro") Integer idLibro);

	@Query("SELECT l FROM Libro l WHERE l.autor.id = :idAutor")
	List<Libro> consultarLibrosAutor(@Param("idAutor") Integer idAutor);
	
}
