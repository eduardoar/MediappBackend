package com.rosales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Medico;

//@Repository
public interface IMedicoRepo extends JpaRepository<Medico, Integer>{

}
