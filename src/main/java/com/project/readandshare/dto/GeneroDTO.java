package com.project.readandshare.dto;

import java.util.List;

public class GeneroDTO  {


	private Integer id;
	private String genero;
	private List<GeneroDTO> generos;
	
	public GeneroDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<GeneroDTO> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroDTO> generos) {
		this.generos = generos;
	}

}
