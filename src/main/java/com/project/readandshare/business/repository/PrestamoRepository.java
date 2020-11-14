package com.project.readandshare.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.readandshare.business.model.Prestamo;

@Repository
public interface PrestamoRepository extends CrudRepository<Prestamo, Integer> {

	
}
