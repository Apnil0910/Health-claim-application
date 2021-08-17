package com.app.healthclaim.healthapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.healthclaim.healthapp.model.PatientDetails;
import com.app.healthclaim.healthapp.repository.PatientDetailsRepository;


@Service
public class PatientDetailsService {
	
	@Autowired 
	private PatientDetailsRepository repo;
	
	public PatientDetails saveUser(PatientDetails details) {
		return repo.save(details);
	}

	
	public void deleteUser(int id) {
		 repo.deleteById(id);
	}
	
	public PatientDetails updateDetials(String fname , String lname) {
		return repo.findAllByFnameAndLname(fname,lname);
	}
}
