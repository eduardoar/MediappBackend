package com.rosales.service;

import com.rosales.model.Usuario;

public interface ILoginService {
	
	Usuario verificarNombreUsuario(String usuario) throws Exception;
	
	void cambiarClave(String clave, String nombre);
	
	
	

}
