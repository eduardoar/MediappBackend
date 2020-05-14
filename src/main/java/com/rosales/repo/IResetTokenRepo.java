package com.rosales.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosales.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	ResetToken findByToken(String token);

}
