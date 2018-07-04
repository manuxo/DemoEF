package com.demo.viewmodel;


import com.demo.models.entities.RankingDiario;
import com.demo.models.entities.Resultado;

public class RankingViewModel {
	private RankingDiario ranking;
	private Resultado resultadoUno;
	private Resultado resultadoDos;
	private Resultado resultadoTres;
	private Resultado resultadoCuatro;
	private String fecha;
	
	//TODO: constructor
	
	public RankingViewModel() {
		this.ranking = new RankingDiario();
		this.resultadoUno = new Resultado();
		this.resultadoDos = new Resultado();
		this.resultadoTres = new Resultado();
		this.resultadoCuatro = new Resultado();
	}
	
	//TODO: getter-setter

	public RankingDiario getRanking() {
		return ranking;
	}

	public void setRanking(RankingDiario ranking) {
		this.ranking = ranking;
	}

	public Resultado getResultadoUno() {
		return resultadoUno;
	}

	public void setResultadoUno(Resultado resultadoUno) {
		this.resultadoUno = resultadoUno;
	}

	public Resultado getResultadoDos() {
		return resultadoDos;
	}

	public void setResultadoDos(Resultado resultadoDos) {
		this.resultadoDos = resultadoDos;
	}

	public Resultado getResultadoTres() {
		return resultadoTres;
	}

	public void setResultadoTres(Resultado resultadoTres) {
		this.resultadoTres = resultadoTres;
	}

	public Resultado getResultadoCuatro() {
		return resultadoCuatro;
	}

	public void setResultadoCuatro(Resultado resultadoCuatro) {
		this.resultadoCuatro = resultadoCuatro;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}//:~
