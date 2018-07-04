package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.models.dao.IRankingDiarioDAO;
import com.demo.models.entities.RankingDiario;
import com.demo.services.IRankingDiarioService;

@Service
public class RankingDiarioService implements IRankingDiarioService {

	
	@Autowired
	private IRankingDiarioDAO rankingRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<RankingDiario> findAll() {
		// TODO Auto-generated method stub
		return rankingRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public RankingDiario findById(Long id) {
		// TODO Auto-generated method stub
		return rankingRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(RankingDiario entity) {
		// TODO Auto-generated method stub
		entity.setEstado("pendiente");
		rankingRepo.save(entity);
	}

	@Override
	@Transactional
	public void delete(RankingDiario entity) {
		// TODO Auto-generated method stub
		rankingRepo.delete(entity);
	}

	@Override
	public void update(RankingDiario entity) {
		// TODO Auto-generated method stub
		entity.setEstado("terminado");
		rankingRepo.save(entity);
	}

}
