package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {

	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("titulo","ACM App - Inicio");
		return "index";
	}
}
