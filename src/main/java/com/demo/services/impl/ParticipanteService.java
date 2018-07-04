package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.models.dao.IParticipanteDAO;
import com.demo.models.entities.Participante;
import com.demo.services.IParticipanteService;

@Service
public class ParticipanteService implements IParticipanteService {

	@Autowired
	private IParticipanteDAO participanteRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Participante> findAll() {
		// TODO Auto-generated method stub
		return participanteRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Participante findById(Long id) {
		// TODO Auto-generated method stub
		return participanteRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Participante entity) {
		// TODO Auto-generated method stub
		participanteRepo.save(entity);
	}

	@Override
	@Transactional
	public void delete(Participante entity) {
		// TODO Auto-generated method stub
		participanteRepo.delete(entity);
	}

	@Override
	public void update(Participante entity) {
		// TODO Auto-generated method stub
		participanteRepo.save(entity);
	}
}
