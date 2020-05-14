package com.rosales.service;

import com.rosales.model.Archivo;

public interface IArchivoService {

	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);
}
