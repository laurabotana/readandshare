package com.project.readandshare.business.service;

import java.util.List;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.DatosValoracionLibroDTO;
import com.project.readandshare.dto.GeneroDTO;
import com.project.readandshare.dto.LibroDTO;
import com.project.readandshare.dto.ValoracionDTO;
import com.project.readandshare.dto.ValoracionLibroDTO;

public interface AltaLibrosService {

	void createAutor(AutorDTO autorDTO) throws ReadandshareException;
	
	void createLibro(LibroDTO libroDTO) throws ReadandshareException;
	
	List<AutorDTO> getListaAutores() throws ReadandshareException;
	
	List<ValoracionLibroDTO> getListaValoraciones() throws ReadandshareException;

	LibroDTO consultarDetalleLibro(Integer id);

	DatosValoracionLibroDTO getValoracionLibro(Integer idLibro, Integer idUsuario);

	void altaValoracion(DatosValoracionLibroDTO datosValoracion) throws ReadandshareException;

	List<GeneroDTO> getListaGeneros() throws ReadandshareException;
	
	List<ValoracionDTO> getListaValoraciones(Integer idLibro) throws ReadandshareException;

	AutorDTO consultarAutor(Integer id);
	
	List<LibroDTO> getLibrosAutor(Integer id) throws ReadandshareException;
	
}
