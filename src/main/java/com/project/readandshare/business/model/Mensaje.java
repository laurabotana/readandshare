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
@Table(name="MENSAJE") 
public class Mensaje implements Serializable {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EMISOR", nullable = false)
    private Integer emisor;
    
    @Column(name = "RECEPTOR", nullable = false)
    private Integer receptor;
    
    @Column(name = "MENSAJE", nullable = false)
    private String mensaje;
    
    @Column(name = "FECHA", nullable = false)
    private String fecha;
    
   	public Mensaje() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmisor() {
		return emisor;
	}

	public void setEmisor(Integer emisor) {
		this.emisor = emisor;
	}

	public Integer getReceptor() {
		return receptor;
	}

	public void setReceptor(Integer receptor) {
		this.receptor = receptor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	
}