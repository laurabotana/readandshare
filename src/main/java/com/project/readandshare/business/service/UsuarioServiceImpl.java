package com.project.readandshare.business.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.readandshare.business.component.PasswordCipherComponent;
import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.model.Mensaje;
import com.project.readandshare.business.model.Usuario;
import com.project.readandshare.business.repository.MensajeRepository;
import com.project.readandshare.business.repository.UsuarioRepository;
import com.project.readandshare.dto.MensajeDTO;
import com.project.readandshare.dto.UsuarioCercanoDTO;
import com.project.readandshare.dto.UsuarioDTO;

@Service(UsuarioServiceImpl.ID)
public class UsuarioServiceImpl implements UsuarioService {

	public static final String ID = "UsuarioServiceImpl";
	
	@Autowired
	private PasswordCipherComponent passwordCipherComponent;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MensajeRepository mensajeRepository;
	
	private void validate(UsuarioDTO usuarioDTO) throws ReadandshareException {
		if(usuarioDTO == null || StringUtils.isEmpty(usuarioDTO.getApellidos()) || StringUtils.isEmpty(usuarioDTO.getLocalidad())
				|| StringUtils.isEmpty(usuarioDTO.getLogin()) || StringUtils.isEmpty(usuarioDTO.getMail()) || StringUtils.isEmpty(usuarioDTO.getNombre())
				|| StringUtils.isEmpty(usuarioDTO.getPassword()) || StringUtils.isEmpty(usuarioDTO.getProvincia())) {
			throw new ReadandshareException("Existen campos obligatorios de Usuario que no se han cubierto");
		}
	}
	
	private void validate(MensajeDTO mensajeDTO) throws ReadandshareException {
		if(mensajeDTO == null || mensajeDTO.getEmisor() == null || mensajeDTO.getReceptor() == null
				|| StringUtils.isEmpty(mensajeDTO.getMensaje())) {
			throw new ReadandshareException("Existen campos obligatorios de Mensaje que no se han cubierto");
		}
	}
	
	@Override
	public void createUsuario(UsuarioDTO usuarioDTO) throws ReadandshareException {
		this.validate(usuarioDTO);
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
		if(login == null || password == null) {
			throw new ReadandshareException("Faltan campos requeridos");
		}
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
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setLogin(usuario.getLogin());
			usuarioDTO.setApellidos(usuario.getApellidos());
			usuarioDTO.setLocalidad(usuario.getLocalidad());
			usuarioDTO.setMail(usuario.getMail());
			usuarioDTO.setNombre(usuario.getNombre());
			usuarioDTO.setProvincia(usuario.getProvincia());
		}
		return usuarioDTO;
	}
	
	@Override
	public UsuarioDTO consultarUsuario(String login) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		Usuario usuario = this.usuarioRepository.consultarUsuario(login);
		if(usuario != null) {
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setLogin(usuario.getLogin());
			usuarioDTO.setLocalidad(usuario.getLocalidad());
			usuarioDTO.setProvincia(usuario.getProvincia());
		}
		return usuarioDTO;
	}
	
	@Override
	public void createMensaje(MensajeDTO mensajeDTO) throws ReadandshareException {
		this.validate(mensajeDTO);
		Usuario emisor = this.usuarioRepository.consultarUsuario(mensajeDTO.getEmisor());
		Usuario receptor = this.usuarioRepository.consultarUsuario(mensajeDTO.getReceptor());
		Mensaje mensaje = new Mensaje();
		mensaje.setMensaje(mensajeDTO.getMensaje());
		mensaje.setEmisor(emisor);
		mensaje.setReceptor(receptor);
		mensaje.setFecha(Calendar.getInstance());
		this.mensajeRepository.save(mensaje);
	}
	
	@Override
	public List<MensajeDTO> getMisMensajes(Integer id) {
		
		List<MensajeDTO> mensajesDTO = new ArrayList<MensajeDTO>();
		
		List<Mensaje> mensajes = this.mensajeRepository.getMisMensajes(id);
		
		if(!CollectionUtils.isEmpty(mensajes)) {
			for(Mensaje mensaje: mensajes) {
				MensajeDTO mensajeDTO = new MensajeDTO();
				mensajeDTO.setId(mensaje.getId());
				mensajeDTO.setEmisor(mensaje.getEmisor().getId());
				mensajeDTO.setAliasEmisor(mensaje.getEmisor().getLogin());
				mensajeDTO.setMensaje(mensaje.getMensaje());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				mensajeDTO.setFecha(simpleDateFormat.format(mensaje.getFecha().getTime()));
				mensajesDTO.add(mensajeDTO);
			}
		}
		
		return mensajesDTO;
	}

	@Override
	public String getUsuariosCercanos(Integer id) {
		String usuariosCercanosString = null;
		List<Usuario> listaUsuarios = this.usuarioRepository.consultarUsuariosCercanos(id);
		List<UsuarioCercanoDTO> listaUsuarioCercano = new ArrayList<UsuarioCercanoDTO>();
		if(!CollectionUtils.isEmpty(listaUsuarios)) {
			for(Usuario u: listaUsuarios) {
				UsuarioCercanoDTO usuarioCercanoDTO = new UsuarioCercanoDTO();
				usuarioCercanoDTO.setAlias(u.getLogin());
				usuarioCercanoDTO.setLocalidad(u.getLocalidad());
				usuarioCercanoDTO.setProvincia(u.getProvincia());
				listaUsuarioCercano.add(usuarioCercanoDTO);
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				usuariosCercanosString = mapper.writeValueAsString(listaUsuarioCercano);
			} catch (JsonProcessingException e) {
				usuariosCercanosString = null;
			}
		}
		return usuariosCercanosString;
	}

}
