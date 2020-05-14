package com.rosales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.Usuario;
import com.rosales.repo.ILoginRepo;
import com.rosales.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginRepo repo;
	
	@Override
	public Usuario verificarNombreUsuario(String usuario) throws Exception {
		return repo.verificarNombreUsuario(usuario);
	}

	@Override
	public void cambiarClave(String clave, String nombre) {
		repo.cambiarClave(clave, nombre);
	}

}
