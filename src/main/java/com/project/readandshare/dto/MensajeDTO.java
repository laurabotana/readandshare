package com.project.readandshare.dto;

public class MensajeDTO  {


	private Integer id;
	private Integer emisor;
	private String aliasEmisor;
	private Integer receptor;
	private String mensaje;
	private String fecha;
	
	public MensajeDTO() {
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
	
	public String getAliasEmisor() {
		return aliasEmisor;
	}

	public void setAliasEmisor(String aliasEmisor) {
		this.aliasEmisor = aliasEmisor;
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
