package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.dao.IResultadoDAO;
import com.demo.models.entities.Resultado;
import com.demo.services.IResultadoService;

@Service
public class ResultadoService implements IResultadoService {

	@Autowired
	private IResultadoDAO resultadoRepo;
	
	@Override
	public List<Resultado> findAll() {
		// TODO Auto-generated method stub
		return resultadoRepo.findAll();
	}

	@Override
	public Resultado findById(Long id) {
		// TODO Auto-generated method stub
		return resultadoRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Resultado entity) {
		// TODO Auto-generated method stub
		resultadoRepo.save(entity);
	}

	@Override
	public void delete(Resultado entity) {
		// TODO Auto-generated method stub
		resultadoRepo.delete(entity);
	}

}
