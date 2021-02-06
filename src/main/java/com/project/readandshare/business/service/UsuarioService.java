package com.project.readandshare.business.service;

import java.util.List;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.dto.MensajeDTO;
import com.project.readandshare.dto.UsuarioDTO;

public interface UsuarioService {

	void createUsuario(UsuarioDTO usuarioDTO) throws ReadandshareException;
	
	Boolean loginUsuario(String login, String password) throws ReadandshareException;
	
	UsuarioDTO consultarDatosUsuario(String login);
	
	void createMensaje(MensajeDTO mensajeDTO) throws ReadandshareException;
	
	List<MensajeDTO> getMisMensajes(Integer id);
	
	String getUsuariosCercanos(Integer id);
	
}
