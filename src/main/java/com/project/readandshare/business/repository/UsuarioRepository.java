package com.project.readandshare.business.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.login = :login")
	Usuario consultarUsuario(@Param("login") String login);

	@Query("SELECT u FROM Usuario u WHERE u.id = :idUsuario")
	Usuario consultarUsuario(@Param("idUsuario") Integer idUsuario);	
	
}
