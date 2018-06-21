package com.demo.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="resultados")
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int puntaje;
	
	@NotNull
	private int puesto;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Participante participante;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private RankingDiario ranking;
	
	//TODO: getter-setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getPuesto() {
		return puesto;
	}

	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public RankingDiario getRanking() {
		return ranking;
	}

	public void setRanking(RankingDiario ranking) {
		this.ranking = ranking;
	}
}
