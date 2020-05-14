package com.rosales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Paciente;

//@Repository
public interface IPacienteRepo extends JpaRepository<Paciente, Integer>{

}
