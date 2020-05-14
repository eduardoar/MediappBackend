package com.rosales.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Examen;
import com.rosales.repo.IExamenRepo;
import com.rosales.service.IExamenService;

@Service
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepo repo;
	
	@Override
	public Examen registrar(Examen obj) {
		//Algoritmo de busqueda
		return repo.save(obj);
	}

	@Override
	public Examen modificar(Examen obj) {
		return repo.save(obj);
	}

	@Override
	public List<Examen> listar() {
		return repo.findAll();
	}

	@Override
	public Examen listarPorId(Integer id) {
		Optional<Examen> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Examen();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
