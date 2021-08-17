package com.app.healthclaim.healthapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.healthclaim.healthapp.model.PatientDetails;

public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Integer> {
	
	public PatientDetails findAllByFnameAndLname(String fname, String lname);

}
