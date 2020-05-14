package com.rosales.service;

import java.util.List;

import com.rosales.dto.ConsultaListaExamenDTO;
import com.rosales.dto.ConsultaResumenDTO;
import com.rosales.dto.FiltroConsultaDTO;
import com.rosales.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta, Integer>{

	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);

	List<Consulta> buscar(FiltroConsultaDTO filtro);

	List<Consulta> buscarFecha(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
	
}
