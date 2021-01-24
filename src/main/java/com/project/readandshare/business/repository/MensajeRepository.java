package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Mensaje;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Integer> {

	@Query("SELECT m FROM Mensaje m WHERE m.receptor.id = :idReceptor ORDER BY m.fecha ASC")
	List<Mensaje> getMisMensajes(@Param("idReceptor") Integer idReceptor);
	
}
