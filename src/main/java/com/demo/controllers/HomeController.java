package com.demo.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.models.entities.Participante;
import com.demo.services.IParticipanteService;
import com.demo.services.IResultadoService;

@Controller
@RequestMapping(value="/")
public class HomeController {

	@Autowired
	private IParticipanteService participanteService;
	
	@Autowired
	private IResultadoService resultadoService;
	
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("titulo","ACM App - Inicio");
		
		List<Participante> participantes = participanteService.findAll();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaI;
		Date fechaF;
		try {
			fechaI = formatter.parse("2018-06-29");
			fechaF = formatter.parse("2018-07-30");
			for(int i = 0; i < participantes.size(); i++) {
				int puntajeAcumulado = resultadoService.sumaPuntajeByParticipanteIdEntreFechas(participantes.get(i).getId(),fechaI,fechaF);
				System.out.print("\n\n\n\n"+ participantes.get(i).getNombre() + puntajeAcumulado + "\n\n\n\n\n");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "index";
	}
}
