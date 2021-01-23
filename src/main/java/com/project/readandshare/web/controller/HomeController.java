package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.AltaLibrosService;
import com.project.readandshare.business.service.UsuarioService;
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
    
	@RequestMapping(value = "/home.html")
	public ModelAndView home(HttpServletRequest request) throws ReadandshareException {
		List<ValoracionLibroDTO> valoraciones = this.altaLibrosService.getListaValoraciones();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("sesionIniciada", this.tieneSesionIniciada(request));
		myModel.put("valoraciones", valoraciones);
		return new ModelAndView("home", "model", myModel);
	}

	@RequestMapping(value = "/cercanos.html")
	public ModelAndView cercanos(HttpServletRequest request) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("sesionIniciada", this.tieneSesionIniciada(request));
		myModel.put("usuariosCercanos", this.usuarioService.getUsuariosCercanos());
		return new ModelAndView("cercanos", "model", myModel);
	}
}
