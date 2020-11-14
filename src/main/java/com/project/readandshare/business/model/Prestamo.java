package com.project.readandshare.business.model;

import java.util.Calendar;

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
@Table(name="PRESTAMO") 
public class Prestamo{

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne
    @JoinColumn(name = "PRESTAMISTA", nullable = false)
    private Usuario prestamista;
    
	@ManyToOne
    @JoinColumn(name = "PRESTATARIO", nullable = false)
    private Usuario prestatario;
    
    @Column(name = "FECHA", nullable = false)
    private Calendar fecha;
    
   	public Prestamo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Usuario getPrestamista() {
		return prestamista;
	}

	public void setPrestamista(Usuario prestamista) {
		this.prestamista = prestamista;
	}

	public Usuario getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(Usuario prestatario) {
		this.prestatario = prestatario;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	

	
	
}