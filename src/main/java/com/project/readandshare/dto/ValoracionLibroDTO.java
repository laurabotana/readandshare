package com.project.readandshare.dto;

import com.project.readandshare.business.model.Libro;

public class ValoracionLibroDTO {
	
	private LibroDTO libro;
	private Double media;
	
	public ValoracionLibroDTO() {
		super();
	}

	public ValoracionLibroDTO(Libro libro, Double media) {
		super();
		this.libro = new LibroDTO(libro);
		this.media = media;
	}

	public LibroDTO getLibro() {
		return libro;
	}

	public void setLibro(LibroDTO libro) {
		this.libro = libro;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

}
