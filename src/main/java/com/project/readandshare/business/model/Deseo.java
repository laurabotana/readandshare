package com.project.readandshare.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DESEO") 
public class Deseo {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USUARIO", nullable = false)
    private Integer usuario;
    
    @Column(name = "LIBRO", nullable = false)
    private Integer libro;
    
    
   	public Deseo() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUsuario() {
		return usuario;
	}


	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}


	public Integer getLibro() {
		return libro;
	}


	public void setLibro(Integer libro) {
		this.libro = libro;
	}


	
		

	
	
}