package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {


}
