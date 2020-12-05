package com.project.readandshare.dto;

import java.util.List;

public class AutorDTO  {


	private Integer id;
	private String nombre;
	private List<LibroDTO> libros;
	
	public AutorDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LibroDTO> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroDTO> libros) {
		this.libros = libros;
	}

}
