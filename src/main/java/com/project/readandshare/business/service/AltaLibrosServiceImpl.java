package com.project.readandshare.business.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.model.Autor;
import com.project.readandshare.business.model.Genero;
import com.project.readandshare.business.model.Libro;
import com.project.readandshare.business.model.LibroGenero;
import com.project.readandshare.business.model.Usuario;
import com.project.readandshare.business.model.Valoracion;
import com.project.readandshare.business.repository.AutorRepository;
import com.project.readandshare.business.repository.GeneroRepository;
import com.project.readandshare.business.repository.LibroGeneroRepository;
import com.project.readandshare.business.repository.LibroRepository;
import com.project.readandshare.business.repository.UsuarioRepository;
import com.project.readandshare.business.repository.ValoracionRepository;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.DatosValoracionLibroDTO;
import com.project.readandshare.dto.GeneroDTO;
import com.project.readandshare.dto.LibroDTO;
import com.project.readandshare.dto.ValoracionDTO;
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
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private LibroGeneroRepository libroGeneroRepository;
	
	private void validateValoracion(DatosValoracionLibroDTO datosValoracion) throws ReadandshareException {
		if(datosValoracion == null || datosValoracion.getIdLibro() == null || datosValoracion.getIdUsuario() == null
				|| datosValoracion.getNota() == null) {
			throw new ReadandshareException("Existen campos obligatorios de Valoración que no se han cubierto");
		}
	}
	
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
		Genero genero = this.generoRepository.consultarGenero(libroDTO.getGenero());
		Libro libro = new Libro();
		libro.setAno(libroDTO.getAno());
		libro.setEditorial(libroDTO.getEditorial());
		libro.setImagen(libroDTO.getImagen().getBytes());
		libro.setNpag(libroDTO.getNumPaginas());	
		libro.setSinopsis(libroDTO.getSinopsis());
		libro.setTitulo(libroDTO.getTitulo());
		libro.setAutor(autor);
		Libro libroGuardado = this.libroRepository.save(libro);
		LibroGenero libroGenero = new LibroGenero();
		libroGenero.setId_libro(libroGuardado);
		libroGenero.setId_genero(genero);
		this.libroGeneroRepository.save(libroGenero);
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
	
	@Override
	public LibroDTO consultarDetalleLibro(Integer id) {
		LibroDTO libroDTO = new LibroDTO();
		Libro libro = this.libroRepository.consultarDetalleLibro(id);
		LibroGenero libroGenero = this.libroGeneroRepository.consultarLibroGenero(id);
		if(libro != null) {
			libroDTO.setTitulo(libro.getTitulo());
			libroDTO.setNombreAutor(libro.getAutor().getNombre());
			libroDTO.setEditorial(libro.getEditorial());
			libroDTO.setAno(libro.getAno());
			libroDTO.setNumPaginas(libro.getNpag());
			libroDTO.setNombreGenero(libroGenero.getId_genero().getGenero());
			libroDTO.setSinopsis(libro.getSinopsis());
			libroDTO.setImagenStr(Base64.getEncoder().encodeToString(libro.getImagen()));
		}
		return libroDTO;
	}

	@Override
	public DatosValoracionLibroDTO getValoracionLibro(Integer idLibro, Integer idUsuario) {
		DatosValoracionLibroDTO valoracionLibro = null;
		Valoracion valoracion = this.valoracionRepository.consultarValoracionLibroUsuario(idLibro, idUsuario);
		if(valoracion != null) {
			valoracionLibro = new DatosValoracionLibroDTO();
			valoracionLibro.setNota(valoracion.getNota());
			valoracionLibro.setCritica(valoracion.getCritica());
		}
		return valoracionLibro;
	}

	@Override
	public void altaValoracion(DatosValoracionLibroDTO datosValoracion) throws ReadandshareException {
		this.validateValoracion(datosValoracion);
		Libro libro = this.libroRepository.consultarDetalleLibro(datosValoracion.getIdLibro());
		Usuario usuario = this.usuarioRepository.consultarUsuario(datosValoracion.getIdUsuario());
		Valoracion valoracion = new Valoracion();
		valoracion.setUsuario(usuario);
		valoracion.setLibro(libro);
		valoracion.setNota(datosValoracion.getNota());
		valoracion.setCritica(datosValoracion.getCritica());
		this.valoracionRepository.save(valoracion);
	}

	@Override
	public List<GeneroDTO> getListaGeneros() throws ReadandshareException {
		List<GeneroDTO> generosDTO = new ArrayList<GeneroDTO>();
		
		List<Genero> generos = this.generoRepository.consultarGeneros();
		
		if(!CollectionUtils.isEmpty(generos)) {
			for(Genero genero: generos) {
				GeneroDTO generoDTO = new GeneroDTO();
				generoDTO.setId(genero.getId());
				generoDTO.setGenero(genero.getGenero());
				generosDTO.add(generoDTO);
			}
		}
		return generosDTO;
	}
	
	@Override
	public List<ValoracionDTO> getListaValoraciones(Integer idLibro) throws ReadandshareException{
		List<ValoracionDTO> valoracionesDTO = new ArrayList<ValoracionDTO>();
		List<Valoracion> valoracionesLibro = this.valoracionRepository.consultarValoraciones(idLibro);
		
		if(!CollectionUtils.isEmpty(valoracionesLibro)) {
			for(Valoracion valoracion: valoracionesLibro) {
				ValoracionDTO valoracionDTO = new ValoracionDTO();
				valoracionDTO.setUsuario(valoracion.getUsuario().getLogin());
				valoracionDTO.setNota(valoracion.getNota());
				valoracionDTO.setCritica(valoracion.getCritica());
			
				valoracionesDTO.add(valoracionDTO);
			}
		}
		return valoracionesDTO;
	
	}
	
	

}
