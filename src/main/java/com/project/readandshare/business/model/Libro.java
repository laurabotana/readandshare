package com.project.readandshare.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LIBRO") 
public class Libro {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;
    
    @Column(name = "EDITORIAL", nullable = false)
    private String editorial;
    
    @Column(name = "ANO", nullable = false)
    private Integer ano;
    
    @Column(name = "NPAG")
    private Integer npag;
    
    @Column(name = "SINOPSIS", nullable = false)
    private String sinopsis;
    
    @ManyToOne
	@JoinColumn(name = "AUTOR", nullable = false)
    private Autor autor;
    
       
    @Column(name = "IMAGEN", nullable = false)
    private byte[] imagen;

	public Libro() {
		super();
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

	public Integer getNpag() {
		return npag;
	}

	public void setNpag(Integer npag) {
		this.npag = npag;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}


	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	

	
	
}