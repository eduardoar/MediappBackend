package com.rosales.service;

import com.rosales.model.ResetToken;

public interface IResetTokenService {
	
	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);
	

}
