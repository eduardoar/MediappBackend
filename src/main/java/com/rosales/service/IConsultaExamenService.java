package com.rosales.service;

import java.util.List;

import com.rosales.model.ConsultaExamen;

public interface IConsultaExamenService {

	List<ConsultaExamen> listarExamenesPorConsulta(Integer idconsulta);

}
