package com.rosales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer>{

}
