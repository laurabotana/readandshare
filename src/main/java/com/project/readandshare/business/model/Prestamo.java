package com.project.readandshare.business.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRESTAMO") 
public class Prestamo implements Serializable {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRESTAMISTA", nullable = false)
    private Integer prestamista;
    
    @Column(name = "PRESTATARIO", nullable = false)
    private Integer prestatario;
    
    @Column(name = "FECHA", nullable = false)
    private String fecha;
    
   	public Prestamo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrestamista() {
		return prestamista;
	}

	public void setPrestamista(Integer prestamista) {
		this.prestamista = prestamista;
	}

	public Integer getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(Integer prestatario) {
		this.prestatario = prestatario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	

	
	
}