package com.project.readandshare.business.service;

import java.util.List;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.LibroDTO;

public interface AltaLibrosService {

	void createAutor(AutorDTO autorDTO) throws ReadandshareException;
	
	void createLibro(LibroDTO libroDTO) throws ReadandshareException;
	
	List<AutorDTO> getListaAutores() throws ReadandshareException;
	
}
