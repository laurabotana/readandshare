package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.readandshare.business.exception.ReadandshareException;
import com.project.readandshare.business.service.AltaLibrosService;
import com.project.readandshare.dto.AutorDTO;
import com.project.readandshare.dto.DatosValoracionLibroDTO;
import com.project.readandshare.dto.GeneroDTO;
import com.project.readandshare.dto.LibroDTO;
import com.project.readandshare.dto.UsuarioDTO;
import com.project.readandshare.dto.ValoracionDTO;
import com.project.readandshare.dto.ValoracionLibroDTO;

@Controller
public class AltaLibrosController {

	@Autowired
	private AltaLibrosService altaLibrosService;

	private Boolean tieneSesionIniciada(HttpServletRequest request) {
		Boolean sesionIniciada = Boolean.FALSE;
		if(request.getSession().getAttribute("usuarioLogueado") != null) {
			sesionIniciada = Boolean.TRUE;
		}
		return sesionIniciada;
	}

	@RequestMapping(value="/formAutor.html")
	public ModelAndView formAutor(HttpServletRequest request) {
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		if(Boolean.FALSE.equals(sesionIniciada)) {
			return new ModelAndView(new RedirectView("login.html"));
		}
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("sesionIniciada", sesionIniciada);
		return new ModelAndView("formAutor", "model", myModel);
	}

	@RequestMapping(value="/addAutor.html", method = RequestMethod.POST)
	public ModelAndView addAutor(AutorDTO autorDTO) throws ReadandshareException {
		this.altaLibrosService.createAutor(autorDTO);
		return new ModelAndView(new RedirectView("home.html"));
	}

	@RequestMapping(value="/formLibro.html")
	public ModelAndView formLibro(HttpServletRequest request) throws ReadandshareException {
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		if(Boolean.FALSE.equals(sesionIniciada)) {
			return new ModelAndView(new RedirectView("login.html"));
		}
		List<AutorDTO> autores = this.altaLibrosService.getListaAutores();
		List<GeneroDTO> generos = this.altaLibrosService.getListaGeneros();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("autores", autores);
		myModel.put("generos", generos);
		myModel.put("sesionIniciada", sesionIniciada);
		return new ModelAndView("formLibro", "model", myModel);
	}

	@RequestMapping(value="/addLibro.html", method = RequestMethod.POST)
	public ModelAndView addLibro(LibroDTO libroDTO) throws ReadandshareException {
		this.altaLibrosService.createLibro(libroDTO);
		return new ModelAndView(new RedirectView("home.html"));
	}

	@RequestMapping(value="/libro.html")
	public ModelAndView detalleLibro(HttpServletRequest request, @RequestParam("id") Integer idLibro) throws ReadandshareException {
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		Map<String, Object> myModel = new HashMap<String, Object>();
		LibroDTO libroDTO = this.altaLibrosService.consultarDetalleLibro(idLibro);
		myModel.put("libro", libroDTO);
		myModel.put("libroValorado", Boolean.FALSE);
		myModel.put("sesionIniciada", sesionIniciada);
		List<ValoracionDTO> valoraciones = this.altaLibrosService.getListaValoraciones(idLibro);
		myModel.put("valoraciones",valoraciones);
		if(Boolean.TRUE.equals(sesionIniciada)) {
			UsuarioDTO usuarioDTO = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
			DatosValoracionLibroDTO valoracionLibro = this.altaLibrosService.getValoracionLibro(idLibro, usuarioDTO.getId());
						myModel.put("libroValoradoUsuarioActual", valoracionLibro != null ? Boolean.TRUE : Boolean.FALSE);
			myModel.put("valoracionLibroUsuarioActual", valoracionLibro);
			myModel.put("idLibro", idLibro);
		}
		return new ModelAndView("detalleLibro", "model", myModel);
	}
	
	@RequestMapping(value="/addValoracion.html", method = RequestMethod.POST)
	public ModelAndView addLibro(HttpServletRequest request, DatosValoracionLibroDTO datosValoracion) throws ReadandshareException {
		ModelAndView mav = null;
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		if(Boolean.TRUE.equals(sesionIniciada)) {
			UsuarioDTO usuarioLogueado = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
			datosValoracion.setIdUsuario(usuarioLogueado.getId());
			this.altaLibrosService.altaValoracion(datosValoracion);
			mav = new ModelAndView(new RedirectView("libro" + datosValoracion.getIdLibro().toString() + ".html"));
		} else {
			mav = new ModelAndView(new RedirectView("login.html")); 
		}
		return mav;
	}
	
	@RequestMapping(value="/autor.html")
	public ModelAndView detalleAutor(HttpServletRequest request, @RequestParam("id") Integer idAutor) throws ReadandshareException {
		Boolean sesionIniciada = this.tieneSesionIniciada(request);
		List<LibroDTO> librosAutor= this.altaLibrosService.getLibrosAutor(idAutor);
		Map<String, Object> myModel = new HashMap<String, Object>();
		AutorDTO autorDTO = this.altaLibrosService.consultarAutor(idAutor);
		myModel.put("autor", autorDTO);
		myModel.put("librosAutor", librosAutor);
		myModel.put("sesionIniciada", sesionIniciada);
		if(Boolean.TRUE.equals(sesionIniciada)) {
			UsuarioDTO usuarioDTO = (UsuarioDTO) request.getSession().getAttribute("usuarioLogueado");
			myModel.put("idAutor", idAutor);
		}
		return new ModelAndView("detalleAutor", "model", myModel);
	}

}

