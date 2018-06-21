package com.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.entities.Participante;

@Repository
public interface IParticipanteDAO extends JpaRepository<Participante, Long> {

}
