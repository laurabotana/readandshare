package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.AltaLibrosService;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.LibroDTO;

@Controller
public class AltaLibrosController {

	//protected final Log logger = LogFactory.getLog(getClass());

	
    
    @Autowired
    private AltaLibrosService altaLibrosService;
	
    @RequestMapping(value="/formAutor.html")
    public ModelAndView formAutor() {		
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("formAutor", "model", myModel);
    }
    
	@RequestMapping(value="/addAutor.html", method = RequestMethod.POST)
	public ModelAndView addAutor(AutorDTO autorDTO) throws ReadandshareException {
		this.altaLibrosService.createAutor(autorDTO);
		return new ModelAndView(new RedirectView("home.html"));
	}
	
	@RequestMapping(value="/formLibro.html")
    public ModelAndView formLibro() throws ReadandshareException {		
		List<AutorDTO> autores = this.altaLibrosService.getListaAutores();
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("autores", autores);
        return new ModelAndView("formLibro", "model", myModel);
    }
    
	@RequestMapping(value="/addLibro.html", method = RequestMethod.POST)
	public ModelAndView addLibro(LibroDTO libroDTO) throws ReadandshareException {
		this.altaLibrosService.createLibro(libroDTO);
		return new ModelAndView(new RedirectView("home.html"));
	}

	
}

