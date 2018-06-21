package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.dao.IParticipanteDAO;
import com.demo.models.entities.Participante;
import com.demo.services.IParticipanteService;

@Service
public class ParticipanteService implements IParticipanteService {

	@Autowired
	private IParticipanteDAO participanteRepo;
	
	@Override
	public List<Participante> findAll() {
		// TODO Auto-generated method stub
		return participanteRepo.findAll();
	}

	@Override
	public Participante findById(Long id) {
		// TODO Auto-generated method stub
		return participanteRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Participante entity) {
		// TODO Auto-generated method stub
		participanteRepo.save(entity);
	}

	@Override
	public void delete(Participante entity) {
		// TODO Auto-generated method stub
		participanteRepo.delete(entity);
	}
}
