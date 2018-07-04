package com.demo.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.entities.Participante;
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
		
		//Ordenar puestos
		List<RankingDiario> rankings = rankingService.findAll();
		for(int i = 0; i < rankings.size(); i++) {
			
			List<Resultado> resultados = rankings.get(i).getResultados();
			
			Collections.sort(resultados, new Comparator<Resultado>(){
				@Override
				public int compare(Resultado r1, Resultado r2) {
					// TODO Auto-generated method stub
					Integer puesto1 = r1.getPuesto();
					Integer puesto2 = r2.getPuesto();
					return puesto1.compareTo(puesto2);
				}
			});
			rankings.get(i).setResultados(resultados);
		}
		
		model.addAttribute("rankings",rankings);
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
		Resultado r1 = rankingViewModel.getResultadoUno();
		r1.setRanking(ranking);
		resultadoService.save(r1);
		Resultado r2 = rankingViewModel.getResultadoDos();
		r2.setRanking(ranking);
		resultadoService.save(r2);
		Resultado r3 = rankingViewModel.getResultadoTres();
		r3.setRanking(ranking);
		resultadoService.save(r3);
		Resultado r4 = rankingViewModel.getResultadoCuatro();
		r4.setRanking(ranking);
		resultadoService.save(r4);
		return "redirect:/ranking/listar";
	}
	
	@GetMapping(value="/ranking/editar/{id}")
	public String editar(Model model, @PathVariable("id") Long id) {
		model.addAttribute("titulo","Ranking - Editar");
		model.addAttribute("ranking",rankingService.findById(id));
		return "ranking/editar";
	}
	
	@PostMapping(value="/ranking/editar/{id}")
	public String actualizar(@RequestParam(name="puesto[]",required=false) int[] puestos
			,@PathVariable("id") Long id) {
		RankingDiario ranking= rankingService.findById(id);
		List<Resultado> resultados = ranking.getResultados();
		for(int i = 0; i < resultados.size(); i++) {
			resultados.get(i).setPuesto(puestos[i]);
			resultadoService.update(resultados.get(i));
		}
		rankingService.update(ranking);
		return "redirect:/ranking/listar";
	}
	
	@PostMapping(value="/ranking/reporte")
	public String reporte(Model model,@RequestParam(name="fechaInicial", required=false) String fechaInicial, 
			@RequestParam(name="fechaFinal", required=false) String fechaFinal) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fechaI = formatter.parse(fechaInicial);
			Date fechaF = formatter.parse(fechaFinal);
			List<Participante> participantes = participanteService.findAll();
			List<Resultado> resultados = new ArrayList<>();
			for(int i = 0; i < participantes.size(); i++) {
				int puntajeAcumulado = resultadoService.sumaPuntajeByParticipanteIdEntreFechas(participantes.get(i).getId(), fechaI, fechaF);
				Resultado resultado = new Resultado();
				resultado.setParticipante(participantes.get(i));
				resultado.setPuntaje(puntajeAcumulado);
				resultados.add(resultado);
			}
			Collections.sort(resultados, new Comparator<Resultado>() {
				@Override
				public int compare(Resultado o1, Resultado o2) {
					// TODO Auto-generated method stub
					Integer puntaje1 = o1.getPuntaje();
					Integer puntaje2 = o2.getPuntaje();
					return puntaje2.compareTo(puntaje1);
				}
			});
			for(int i = 0; i < resultados.size(); i++) {
				resultados.get(i).setPuesto(i + 1);
			}
			
			model.addAttribute("resultados",resultados);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ranking/reporte";
	}
	
}
