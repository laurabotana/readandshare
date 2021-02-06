package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.UsuarioService;
import com.project.readandshare.dto.MensajeDTO;
import com.project.readandshare.dto.UsuarioDTO;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    private Boolean tieneSesionIniciada(HttpServletRequest request) {
    	Boolean sesionIniciada = Boolean.FALSE;
    	if(request.getSession().getAttribute("usuarioLogueado") != null) {
    		sesionIniciada = Boolean.TRUE;
    	}
    	return sesionIniciada;
    }
     
    @RequestMapping(value="/miPerfil.html", method = RequestMethod.GET)
    public ModelAndView miPerfil(HttpServletRequest request) {
    	Boolean sesionIniciada = this.tieneSesionIniciada(request);
    	if(Boolean.FALSE.equals(sesionIniciada)) {
    		return new ModelAndView(new RedirectView("login.html"));
    	}
    	UsuarioDTO usuarioDTO = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
    	List<MensajeDTO> mensajes = this.usuarioService.getMisMensajes(usuarioDTO.getId());
    	
    	Map<String, Object> miPerfil = new HashMap<String, Object>();
        miPerfil.put("sesionIniciada", sesionIniciada);
        miPerfil.put("alias", usuarioDTO.getLogin());
        miPerfil.put("usuario", usuarioDTO);
        miPerfil.put("mensajes", mensajes);
        return new ModelAndView("miPerfil", "model", miPerfil);
    }
    
    @RequestMapping(value="/login.html", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
    	Boolean sesionIniciada = this.tieneSesionIniciada(request);
    	if(Boolean.TRUE.equals(sesionIniciada)) {
    		return new ModelAndView(new RedirectView("home.html"));
    	}
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("sesionIniciada", Boolean.FALSE);
        return new ModelAndView("login", "model", myModel);
    }

    @RequestMapping(value="/logout.html", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
    	Boolean sesionIniciada = this.tieneSesionIniciada(request);
    	if(Boolean.TRUE.equals(sesionIniciada)) {
    		request.getSession().removeAttribute("usuarioLogueado");
    	}
        return new ModelAndView(new RedirectView("home.html"));
    }
    
    @RequestMapping(value="/formRegistro.html", method = RequestMethod.GET)
    public ModelAndView formRegistro() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("sesionIniciada", Boolean.FALSE);
        return new ModelAndView("formRegistro", "model", myModel);
    }
    
	@RequestMapping(value="/addUsuario.html", method = RequestMethod.POST)
	public ModelAndView addUsuario(HttpServletRequest request, UsuarioDTO usuarioDTO) throws ReadandshareException {
		this.usuarioService.createUsuario(usuarioDTO);
		UsuarioDTO datosUsuarioLogueado = this.usuarioService.consultarDatosUsuario(usuarioDTO.getLogin());
		request.getSession().setAttribute("usuarioLogueado", datosUsuarioLogueado);
		return new ModelAndView(new RedirectView("miPerfil.html"));
	}
	
	@RequestMapping(value="/loginUsuario.html", method = RequestMethod.POST)
	public ModelAndView loginUsuario(HttpServletRequest request, UsuarioDTO usuarioDTO) throws ReadandshareException {
		Boolean usuarioLogueado = this.usuarioService.loginUsuario(usuarioDTO.getLogin(), usuarioDTO.getPassword());
		ModelAndView model = null;
		if(usuarioLogueado) {
			UsuarioDTO datosUsuarioLogueado = this.usuarioService.consultarDatosUsuario(usuarioDTO.getLogin());
			request.getSession().setAttribute("usuarioLogueado", datosUsuarioLogueado);
			model = new ModelAndView(new RedirectView("home.html"));
		}
		return model;
	}
	
	@RequestMapping(value="/usuario.html", method = RequestMethod.GET)
	public ModelAndView usuario(HttpServletRequest request, @RequestParam("alias") String alias) throws ReadandshareException {
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		if(Boolean.FALSE.equals(sesionIniciada)) {
    		return new ModelAndView(new RedirectView("login.html"));
    	}
		UsuarioDTO usuarioDTO = usuarioService.consultarDatosUsuario(alias);
		if(!usuarioDTO.isVisible()) {
			usuarioDTO.setProvincia(null);
			usuarioDTO.setLocalidad(null);
		}
        Map<String, Object> usuario = new HashMap<String, Object>();
        usuario.put("sesionIniciada", sesionIniciada);        
        usuario.put("usuario", usuarioDTO);
        UsuarioDTO usuarioOrigen = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
        usuario.put("usuarioOrigen", usuarioOrigen);
        usuario.put("alias", usuarioOrigen.getLogin());
        return new ModelAndView("usuario", "model", usuario);
	}
	
	@RequestMapping(value="/mandarMensaje.html", method = RequestMethod.POST)
	public ModelAndView mandarMensaje(MensajeDTO mensajeDTO) throws ReadandshareException {
		this.usuarioService.createMensaje(mensajeDTO);
		return new ModelAndView(new RedirectView("home.html"));
	}
	
}
