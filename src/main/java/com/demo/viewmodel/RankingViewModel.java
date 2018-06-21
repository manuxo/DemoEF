package com.demo.viewmodel;


import com.demo.models.entities.RankingDiario;
import com.demo.models.entities.Resultado;

public class RankingViewModel {
	private RankingDiario ranking;
	private Resultado primerLugar;
	private Resultado segundoLugar;
	private Resultado tercerLugar;
	private Resultado cuartoLugar;
	private String fecha;
	
	//TODO: constructor
	
	public RankingViewModel() {
		this.ranking = new RankingDiario();
		this.primerLugar = new Resultado();
		this.segundoLugar = new Resultado();
		this.tercerLugar = new Resultado();
		this.cuartoLugar = new Resultado();
	}
	
	//TODO: getter-setter
	
	public RankingDiario getRanking() {
		return ranking;
	}
	public void setRanking(RankingDiario ranking) {
		this.ranking = ranking;
	}
	public Resultado getPrimerLugar() {
		return primerLugar;
	}
	public void setPrimerLugar(Resultado primerLugar) {
		this.primerLugar = primerLugar;
	}
	public Resultado getSegundoLugar() {
		return segundoLugar;
	}
	public void setSegundoLugar(Resultado segundoLugar) {
		this.segundoLugar = segundoLugar;
	}
	public Resultado getTercerLugar() {
		return tercerLugar;
	}
	public void setTercerLugar(Resultado tercerLugar) {
		this.tercerLugar = tercerLugar;
	}
	public Resultado getCuartoLugar() {
		return cuartoLugar;
	}
	public void setCuartoLugar(Resultado cuartoLugar) {
		this.cuartoLugar = cuartoLugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
