package com.project.readandshare.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/home.html")
	public ModelAndView home() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("home", "model", myModel);
	}

	@RequestMapping(value = "/cercanos.html")
	public ModelAndView cercanos() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		return new ModelAndView("cercanos", "model", myModel);
	}
}
