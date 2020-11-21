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
		usuario.setMail(usuarioDTO.getMail());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setProvincia(usuarioDTO.getProvincia());
		usuario.setLocalidad(usuarioDTO.getLocalidad());
		this.usuarioRepository.save(usuario);
	}

	@Override
	public Boolean loginUsuario(String login, String password) throws ReadandshareException {
		Boolean credencialesCorrectas = false;
		String passwordEncrypted = this.passwordCipherComponent.encrypt(password);
		Usuario usuario = this.usuarioRepository.consultarUsuario(login);
		if(usuario != null) {
			if(usuario.getPassword().equals(passwordEncrypted)) {
				credencialesCorrectas = true;
			}
		}
		return credencialesCorrectas;
	}

	@Override
	public UsuarioDTO consultarDatosUsuario(String login) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		Usuario usuario = this.usuarioRepository.consultarUsuario(login);
		if(usuario != null) {
			usuarioDTO.setApellidos(usuario.getApellidos());
			usuarioDTO.setLocalidad(usuario.getLocalidad());
			usuarioDTO.setMail(usuario.getMail());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setProvincia(usuario.getProvincia());
		}
		return usuarioDTO;
	}

}
