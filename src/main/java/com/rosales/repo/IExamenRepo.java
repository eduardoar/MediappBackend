package com.rosales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Examen;

//@Repository
public interface IExamenRepo extends JpaRepository<Examen, Integer>{

}
