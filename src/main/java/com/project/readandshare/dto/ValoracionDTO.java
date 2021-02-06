package com.project.readandshare.dto;

public class ValoracionDTO {
	
	private Integer nota;
	private String usuario;
	private Boolean usuarioVisible;
	private String critica;
	
	public ValoracionDTO() {
		super();
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public Boolean getUsuarioVisible() {
		return usuarioVisible;
	}
	public void setUsuarioVisible(Boolean usuarioVisible) {
		this.usuarioVisible = usuarioVisible;
	}
	
	public String getCritica() {
		return critica;
	}
	public void setCritica(String critica) {
		this.critica = critica;
	}
}
