package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.UsuarioService;
import com.project.readandshare.dto.UsuarioDTO;

@Controller
public class HomeController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value="/home.html")
    public ModelAndView home() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("home", "model", myModel);
    }
    
    @RequestMapping(value="/cercanos.html")
    public ModelAndView cercanos() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("cercanos", "model", myModel);
    }
    
    @RequestMapping(value="/miPerfil.html")
    public ModelAndView miPerfil() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("miPerfil", "model", myModel);
    }
    
    @RequestMapping(value="/register.html")
    public ModelAndView register() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("register", "model", myModel);
    }
    
	@RequestMapping(value="/addUsuario.html", method = RequestMethod.POST)
	public void addUsuario(UsuarioDTO usuarioDTO) throws ReadandshareException {
		this.usuarioService.createUsuario(usuarioDTO);	}
}
