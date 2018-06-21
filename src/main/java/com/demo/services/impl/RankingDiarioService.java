package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.dao.IRankingDiarioDAO;
import com.demo.models.entities.RankingDiario;
import com.demo.services.IRankingDiarioService;

@Service
public class RankingDiarioService implements IRankingDiarioService {

	
	@Autowired
	private IRankingDiarioDAO rankingRepo;
	
	@Override
	public List<RankingDiario> findAll() {
		// TODO Auto-generated method stub
		return rankingRepo.findAll();
	}

	@Override
	public RankingDiario findById(Long id) {
		// TODO Auto-generated method stub
		return rankingRepo.findById(id).orElse(null);
	}

	@Override
	public void save(RankingDiario entity) {
		// TODO Auto-generated method stub
		rankingRepo.save(entity);
	}

	@Override
	public void delete(RankingDiario entity) {
		// TODO Auto-generated method stub
		rankingRepo.delete(entity);
	}

}
