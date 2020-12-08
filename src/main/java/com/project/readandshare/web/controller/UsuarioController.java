package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.UsuarioService;
import com.project.readandshare.dto.UsuarioDTO;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    private Boolean tieneSesionIniciada(HttpServletRequest request) {
    	Boolean sesionIniciada = Boolean.FALSE;
    	if(request.getSession().getAttribute("login") != null) {
    		sesionIniciada = Boolean.TRUE;
    	}
    	return sesionIniciada;
    }
     
    @RequestMapping(value="/miPerfil.html")
    public ModelAndView miPerfil(HttpServletRequest request) {
    	Boolean sesionIniciada = this.tieneSesionIniciada(request);
    	if(Boolean.FALSE.equals(sesionIniciada)) {
    		return new ModelAndView(new RedirectView("login.html"));
    	}
    	String login = (String) request.getSession().getAttribute("login");
    	UsuarioDTO usuarioDTO = this.usuarioService.consultarDatosUsuario(login);
        Map<String, Object> miPerfil = new HashMap<String, Object>();
        miPerfil.put("sesionIniciada", sesionIniciada);
        miPerfil.put("usuario", usuarioDTO);
        return new ModelAndView("miPerfil", "model", miPerfil);
    }
    
    @RequestMapping(value="/login.html")
    public ModelAndView login() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("sesionIniciada", Boolean.FALSE);
        return new ModelAndView("login", "model", myModel);
    }

    @RequestMapping(value="/logout.html")
    public ModelAndView logout(HttpServletRequest request) {
    	request.getSession().removeAttribute("login");
        return new ModelAndView(new RedirectView("home.html"));
    }
    
    @RequestMapping(value="/formRegistro.html")
    public ModelAndView formRegistro() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("sesionIniciada", Boolean.FALSE);
        return new ModelAndView("formRegistro", "model", myModel);
    }
    
	@RequestMapping(value="/addUsuario.html", method = RequestMethod.POST)
	public ModelAndView addUsuario(HttpServletRequest request, UsuarioDTO usuarioDTO) throws ReadandshareException {
		this.usuarioService.createUsuario(usuarioDTO);
		request.getSession().setAttribute("login", usuarioDTO.getLogin());
		return new ModelAndView(new RedirectView("miPerfil.html"));
	}
	
	@RequestMapping(value="/loginUsuario.html", method = RequestMethod.POST)
	public ModelAndView loginUsuario(HttpServletRequest request, UsuarioDTO usuarioDTO) throws ReadandshareException {
		Boolean usuarioLogueado = this.usuarioService.loginUsuario(usuarioDTO.getLogin(), usuarioDTO.getPassword());
		ModelAndView model = null;
		if(usuarioLogueado) {
			request.getSession().setAttribute("login", usuarioDTO.getLogin());
			model = new ModelAndView(new RedirectView("home.html"));
		}
		return model;
	}
}
