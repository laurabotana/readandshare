package com.project.readandshare.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.model.Autor;
import com.project.readandshare.business.model.Libro;
import com.project.readandshare.business.repository.AutorRepository;
import com.project.readandshare.business.repository.LibroRepository;
import com.project.readandshare.business.repository.ValoracionRepository;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.LibroDTO;
import com.project.readandshare.dto.ValoracionLibroDTO;

@Service(AltaLibrosServiceImpl.ID)
public class AltaLibrosServiceImpl implements AltaLibrosService {

	public static final String ID = "AltaLibrosServiceImpl";
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private ValoracionRepository valoracionRepository;
	
	private void validateAutor(AutorDTO autorDTO) throws ReadandshareException {
		if(autorDTO == null || autorDTO.getNombre() == null) {
			throw new ReadandshareException("Existen campos obligatorios de Autor que no se han cubierto");
		}
	}
	
	private void validateLibro(LibroDTO libroDTO) throws ReadandshareException {
		if(libroDTO == null || libroDTO.getAno() == null || libroDTO.getAutor() == null || libroDTO.getEditorial() == null
				|| libroDTO.getImagen() == null || libroDTO.getImagen().getSize() == 0
				|| libroDTO.getSinopsis() == null || libroDTO.getTitulo() == null) {
			throw new ReadandshareException("Existen campos obligatorios de Libro que no se han cubierto");
		}
	}
	
	@Override
	public void createAutor(AutorDTO autorDTO) throws ReadandshareException {
		this.validateAutor(autorDTO);
		Autor autor = new Autor();
		autor.setNombre(autorDTO.getNombre());
		this.autorRepository.save(autor);
	}

	@Override
	public void createLibro(LibroDTO libroDTO) throws ReadandshareException {
		this.validateLibro(libroDTO);
		Autor autor = this.autorRepository.consultarAutor(libroDTO.getAutor());
		Libro libro = new Libro();
		libro.setAno(libroDTO.getAno());
		libro.setEditorial(libroDTO.getEditorial());
		libro.setImagen(libroDTO.getImagen().getBytes());
		libro.setNpag(libroDTO.getNumPaginas());	
		libro.setSinopsis(libroDTO.getSinopsis());
		libro.setTitulo(libroDTO.getTitulo());
		libro.setAutor(autor);
		this.libroRepository.save(libro);
	}

	@Override
	public List<AutorDTO> getListaAutores() throws ReadandshareException {
		
		List<AutorDTO> autoresDTO = new ArrayList<AutorDTO>();
		
		List<Autor> autores = this.autorRepository.consultarAutores();
		
		if(!CollectionUtils.isEmpty(autores)) {
			for(Autor autor: autores) {
				AutorDTO autorDTO = new AutorDTO();
				autorDTO.setId(autor.getId());
				autorDTO.setNombre(autor.getNombre());
				autoresDTO.add(autorDTO);
			}
		}
		
		return autoresDTO;
	}

	@Override
	public List<ValoracionLibroDTO> getListaValoraciones() throws ReadandshareException {
		List<ValoracionLibroDTO> valoraciones = this.valoracionRepository.consultarLibrosValoraciones();
		return valoraciones;
	}

}
