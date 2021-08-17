package com.app.healthclaim.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.healthclaim.healthapp.model.User;
import com.app.healthclaim.healthapp.repository.RegisterRepository;

@Service
public class RegisterService {

	
	@Autowired
	private RegisterRepository repo ;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchdetailslbyEmailId(String email) {
		return repo.findAllByEmail(email);
		
	}
	
	public User fetchdetailslbyEmailIdAndPassword(String email, String password) {
		return repo.findAllByEmailAndPassword(email,password);
		
	}
}
