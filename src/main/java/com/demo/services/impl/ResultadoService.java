package com.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.models.dao.IResultadoDAO;
import com.demo.models.entities.Resultado;
import com.demo.services.IResultadoService;

@Service
public class ResultadoService implements IResultadoService {

	@Autowired
	private IResultadoDAO resultadoRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Resultado> findAll() {
		// TODO Auto-generated method stub
		return resultadoRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Resultado findById(Long id) {
		// TODO Auto-generated method stub
		return resultadoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Resultado entity) {
		// TODO Auto-generated method stub
		this.calcularPuntaje(entity);
		resultadoRepo.save(entity);
	}

	@Override
	@Transactional
	public void delete(Resultado entity) {
		// TODO Auto-generated method stub
		resultadoRepo.delete(entity);
	}
	
	private void calcularPuntaje(Resultado entity) {
		switch(entity.getPuesto()) {
		case 1:
			entity.setPuntaje(5);
			break;
		case 2:
			entity.setPuntaje(3);
			break;
		case 3:
			entity.setPuntaje(2);
			break;
		case 4:
			entity.setPuntaje(1);
			break;
		}
	}

}
