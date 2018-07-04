package com.demo.models.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.entities.Resultado;

@Repository
public interface IResultadoDAO extends JpaRepository<Resultado, Long> {

	@Query(value="SELECT SUM(re.puntaje) FROM ranking_diario r " + 
			"INNER JOIN resultados re ON re.ranking_id = r.id " + 
			"INNER JOIN participantes p ON p.id = re.participante_id " + 
			"WHERE r.fecha between :fechaInicial and :fechaFinal " + 
			"GROUP BY p.id " + 
			"HAVING p.id = :id",nativeQuery=true)
	public int sumaPuntajeByParticipanteIdEntreFechas(@Param("id") Long id, @Param("fechaInicial") Date fechaInicial, 
			@Param("fechaFinal") Date fechaFinal);
}
