package com.project.readandshare.business.service;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.dto.UsuarioDTO;

public interface UsuarioService {

	void createUsuario(UsuarioDTO usuarioDTO) throws ReadandshareException;
	
}
