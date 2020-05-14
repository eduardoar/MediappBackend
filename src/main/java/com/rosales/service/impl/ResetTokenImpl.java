package com.rosales.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rosales.model.ResetToken;
import com.rosales.repo.IResetTokenRepo;
import com.rosales.service.IResetTokenService;

@Service
public class ResetTokenImpl implements IResetTokenService {

	
	@Autowired
	private IResetTokenRepo repo;
	
	@Override
	public ResetToken findByToken(String token) {
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);
		
	}

	@Override
	public void eliminar(ResetToken token) {
		repo.delete(token);	
	}
	
}
