package com.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.entities.RankingDiario;

@Repository
public interface IRankingDiarioDAO extends JpaRepository<RankingDiario, Long> {

}
