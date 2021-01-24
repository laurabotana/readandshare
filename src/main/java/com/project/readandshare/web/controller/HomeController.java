package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.AltaLibrosService;
import com.project.readandshare.business.service.UsuarioService;
import com.project.readandshare.dto.UsuarioDTO;
import com.project.readandshare.dto.ValoracionLibroDTO;

@Controller
public class HomeController {
	
    @Autowired
    private AltaLibrosService altaLibrosService;
    
    @Autowired
    private UsuarioService usuarioService;

    private Boolean tieneSesionIniciada(HttpServletRequest request) {
    	Boolean sesionIniciada = Boolean.FALSE;
    	if(request.getSession().getAttribute("usuarioLogueado") != null) {
    		sesionIniciada = Boolean.TRUE;
    	}
    	return sesionIniciada;
    }
    
	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) throws ReadandshareException {
		List<ValoracionLibroDTO> valoraciones = this.altaLibrosService.getListaValoraciones();
		Map<String, Object> myModel = new HashMap<String, Object>();
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		myModel.put("sesionIniciada", sesionIniciada);
		if(Boolean.TRUE.equals(sesionIniciada)) {
			UsuarioDTO usuarioSesion = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
			myModel.put("alias", usuarioSesion.getLogin());
		}
		myModel.put("valoraciones", valoraciones);
		return new ModelAndView("home", "model", myModel);
	}

	@RequestMapping(value = "/cercanos.html", method = RequestMethod.GET)
	public ModelAndView cercanos(HttpServletRequest request) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		myModel.put("sesionIniciada", sesionIniciada);
		if(Boolean.TRUE.equals(sesionIniciada)) {
			UsuarioDTO usuarioSesion = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
			myModel.put("alias", usuarioSesion.getLogin());
			myModel.put("usuariosCercanos", this.usuarioService.getUsuariosCercanos(usuarioSesion.getId()));
		}
		return new ModelAndView("cercanos", "model", myModel);
	}
}
