package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Valoracion;
import com.project.readandshare.dto.ValoracionLibroDTO;

@Repository
public interface ValoracionRepository extends CrudRepository<Valoracion, Integer> {

	@Query("SELECT new com.project.readandshare.dto.ValoracionLibroDTO(l, AVG(v.nota)) "
		+	"FROM Valoracion v RIGHT JOIN v.libro l GROUP BY l ORDER BY AVG(v.nota) DESC")
	List<ValoracionLibroDTO> consultarLibrosValoraciones();

}
