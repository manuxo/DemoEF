package com.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.entities.Resultado;

@Repository
public interface IResultadoDAO extends JpaRepository<Resultado, Long> {

}
