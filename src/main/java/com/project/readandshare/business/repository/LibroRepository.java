package com.project.readandshare.business.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Libro;


@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {
	
	@Query("SELECT d FROM Libro d WHERE d.id = :id")
	Libro consultarDetalleLibro(@Param("id") Integer c);

	
}
