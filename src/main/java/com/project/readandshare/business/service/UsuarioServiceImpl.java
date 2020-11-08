package com.project.readandshare.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.readandshare.business.component.PasswordCipherComponent;
import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.model.Usuario;
import com.project.readandshare.business.repository.UsuarioRepository;
import com.project.readandshare.dto.UsuarioDTO;

@Service(UsuarioServiceImpl.ID)
public class UsuarioServiceImpl implements UsuarioService {

	public static final String ID = "UsuarioServiceImpl";
	
	@Autowired
	private PasswordCipherComponent passwordCipherComponent;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void createUsuario(UsuarioDTO usuarioDTO) throws ReadandshareException {
		Usuario usuario = new Usuario();
		usuario.setLogin(usuarioDTO.getLogin());
		usuario.setPassword(this.passwordCipherComponent.encrypt(usuarioDTO.getPassword()));
		this.usuarioRepository.save(usuario);
	}

}
