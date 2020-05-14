package com.rosales.service;

import java.util.List;

import com.rosales.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
