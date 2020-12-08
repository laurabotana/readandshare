package com.project.readandshare.dto;

import java.io.Serializable;
import java.util.Base64;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.readandshare.business.model.Libro;

public class LibroDTO implements Serializable {

	private static final long serialVersionUID = 9063972672756616961L;
	
	private Integer id;
	private String titulo;
	private String editorial;
	private Integer ano;
	private Integer numPaginas;
	private String sinopsis;
	private CommonsMultipartFile imagen;
	private String imagenStr;
	private Integer autor;
	private String nombreAutor;
	
	public LibroDTO() {
		super();
	}
	
	public LibroDTO(Libro libro) {
		super();
		this.id = libro.getId();
		this.titulo = libro.getTitulo();
		this.nombreAutor = libro.getAutor().getNombre();
		this.imagenStr = Base64.getEncoder().encodeToString(libro.getImagen());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public CommonsMultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(CommonsMultipartFile imagen) {
		this.imagen = imagen;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getImagenStr() {
		return imagenStr;
	}

	public void setImagenStr(String imagenStr) {
		this.imagenStr = imagenStr;
	}

}
