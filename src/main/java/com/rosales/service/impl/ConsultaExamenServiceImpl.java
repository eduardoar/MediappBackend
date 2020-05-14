package com.rosales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.ConsultaExamen;
import com.rosales.repo.IConsultaExamenRepo;
import com.rosales.service.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService{

	@Autowired
	private IConsultaExamenRepo repo;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta) {
		return repo.listarExamenesPorConsulta(idconsulta);
	}
}
