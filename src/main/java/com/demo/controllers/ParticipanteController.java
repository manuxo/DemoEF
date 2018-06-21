package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.models.entities.Participante;
import com.demo.services.IParticipanteService;

@Controller
public class ParticipanteController {

	@Autowired
	private IParticipanteService participanteService;
	
	private List<String> sedes(){
		List<String> sedes = new ArrayList<>();
		
		sedes.add("Monterrico");
		sedes.add("San Isidro");
		sedes.add("Villa");
		sedes.add("San Miguel");
		return sedes;
	}
	
	@GetMapping("/participante/listar")
	private String listar(Model model) {
		model.addAttribute("titulo", "Participantes");
		model.addAttribute("participantes",participanteService.findAll());
		return "participante/listar";
	}
	
	@GetMapping(value="/participante/registrar")
	private String registrar(Model model) {
		model.addAttribute("titulo","Participante - Nuevo");
		model.addAttribute("participante", new Participante());
		model.addAttribute("sedes",this.sedes());
		return "participante/registrar";
	}
	
	@PostMapping(value="/participante/registrar")
	private String guardar(@Valid Participante participante) {
		participanteService.save(participante);
		return "redirect:/participante/listar";
	}
}
