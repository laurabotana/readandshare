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
@Table(name="LIBRO_GENERO") 
public class LibroGenero {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "ID_LIBRO")
    private Libro id_libro;

	@ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero id_genero;
   
   	public LibroGenero() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Libro getId_libro() {
		return id_libro;
	}

	public void setId_libro(Libro id_libro) {
		this.id_libro = id_libro;
	}

	public Genero getId_genero() {
		return id_genero;
	}

	public void setId_genero(Genero id_genero) {
		this.id_genero = id_genero;
	}
	
   	
}