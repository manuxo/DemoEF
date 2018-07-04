package com.demo.services;

import java.util.Date;

import com.demo.models.entities.Resultado;

public interface IResultadoService extends IService<Resultado, Long> {
	public int sumaPuntajeByParticipanteIdEntreFechas(Long id, Date fechaInicial, Date fechaFinal);
}
