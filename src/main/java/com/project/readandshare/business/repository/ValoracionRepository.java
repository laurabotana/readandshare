package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Valoracion;
import com.project.readandshare.dto.ValoracionLibroDTO;

@Repository
public interface ValoracionRepository extends CrudRepository<Valoracion, Integer> {

	@Query("SELECT new com.project.readandshare.dto.ValoracionLibroDTO(l, AVG(v.nota)) "
		+	"FROM Valoracion v RIGHT JOIN v.libro l GROUP BY l ORDER BY AVG(v.nota) DESC")
	List<ValoracionLibroDTO> consultarLibrosValoraciones();

	@Query("SELECT v FROM Valoracion v INNER JOIN v.libro l INNER JOIN v.usuario u WHERE l.id = :idLibro AND u.id = :idUsuario")
	Valoracion consultarValoracionLibroUsuario(@Param("idLibro") Integer idLibro, @Param("idUsuario") Integer idUsuario);
	
	@Query("SELECT v FROM Valoracion v where v.libro.id = :idLibro and v.critica IS NOT NULL")
	List<Valoracion> consultarValoraciones(@Param("idLibro") Integer idLibro);

}
