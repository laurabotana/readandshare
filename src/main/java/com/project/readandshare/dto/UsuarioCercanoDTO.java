package com.project.readandshare.dto;

public class UsuarioCercanoDTO {
	
	private String alias;
	private String localidad;
	private String provincia;
	
	public UsuarioCercanoDTO() {
		super();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
