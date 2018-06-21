package com.demo.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.models.entities.RankingDiario;
import com.demo.models.entities.Resultado;
import com.demo.services.IParticipanteService;
import com.demo.services.IRankingDiarioService;
import com.demo.services.IResultadoService;
import com.demo.viewmodel.RankingViewModel;

@Controller
public class RankingController {

	@Autowired
	private IRankingDiarioService rankingService;
	
	@Autowired
	private IResultadoService resultadoService;
	
	@Autowired
	private IParticipanteService participanteService;

	@GetMapping(value="/ranking/listar")
	public String listar(Model model) {
		model.addAttribute("titulo","Ranking Diario");
		model.addAttribute("rankings",rankingService.findAll());
		return "ranking/listar";
	}
	
	
	@GetMapping(value="/ranking/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("titulo","Ranking - Nuevo");
		model.addAttribute("rankingViewModel", new RankingViewModel());
		model.addAttribute("participantes",participanteService.findAll());
		return "ranking/nuevo";
	}
	
	@PostMapping(value="/ranking/nuevo")
	public String guardar(@Valid RankingViewModel rankingViewModel) {
		
		RankingDiario ranking = rankingViewModel.getRanking();
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			ranking.setFecha(formatter.parse(rankingViewModel.getFecha()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		rankingService.save(ranking);
		
		Resultado r1 = rankingViewModel.getPrimerLugar();
		r1.setRanking(ranking);
		r1.setPuesto(1);
		resultadoService.save(r1);
		Resultado r2 = rankingViewModel.getSegundoLugar();
		r2.setRanking(ranking);
		r2.setPuesto(2);
		resultadoService.save(r2);
		Resultado r3 = rankingViewModel.getTercerLugar();
		r3.setRanking(ranking);
		r3.setPuesto(3);
		resultadoService.save(r3);
		Resultado r4 = rankingViewModel.getCuartoLugar();
		r4.setRanking(ranking);
		r4.setPuesto(4);
		resultadoService.save(r4);
		
		
		return "redirect:/ranking/listar";
	}
}
