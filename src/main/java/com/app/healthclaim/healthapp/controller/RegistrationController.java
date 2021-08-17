package com.app.healthclaim.healthapp.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.healthclaim.healthapp.model.PatientDetails;
import com.app.healthclaim.healthapp.model.User;
import com.app.healthclaim.healthapp.service.PatientDetailsService;
import com.app.healthclaim.healthapp.service.RegisterService;

@RestController
public class RegistrationController {
	
	Logger log = LoggerFactory.logger(RegistrationController.class);
	
	@Autowired 
	private RegisterService serviceObj;
	
	@Autowired
	private PatientDetailsService detailsObj;
	
	@PostMapping("/updateperson")
	@CrossOrigin(origins="http://localhost:4200")
	public PatientDetails updateDetails(@RequestBody PatientDetails ldetails) throws Exception {
		PatientDetails details = null;
		details =  detailsObj.updateDetials(ldetails.getFname() , ldetails.getLname());
		if(details !=null ) {
			if(ldetails.getState() != null && !ldetails.getState().equals("")) {
            ldetails.setState(ldetails.getState());
			} else {
			ldetails.setState(details.getState());
			}
			if(ldetails.getEmail() != null && !ldetails.getEmail().equals("")) {
            ldetails.setEmail(ldetails.getEmail());
			}else {
			ldetails.setEmail(details.getEmail());
			}
			if(ldetails.getContactno() != 0) {
            ldetails.setContactno(ldetails.getContactno());
			}else {
			ldetails.setContactno(details.getContactno());
			}
			if(ldetails.getPanNo() != null && !ldetails.getPanNo().equals("")) {
            ldetails.setPanNo(ldetails.getPanNo());
			}else {
			ldetails.setPanNo(details.getPanNo());
			}
			if(ldetails.getAddress() != null && !ldetails.getAddress().equals("")) {
            ldetails.setAddress(ldetails.getAddress());
			}else {
			ldetails.setAddress(details.getAddress());
			}
			ldetails.setDob(details.getDob());
			ldetails.setCountry(details.getCountry());
			ldetails.setTotalBillAmt(details.getTotalBillAmt());
			ldetails.setDateofAdmission(details.getDateofAdmission());
			ldetails.setDateofDischarge(details.getDateofDischarge());
			ldetails.setProviderName(details.getProviderName());
			
			int idUpdated  = details.getId();
			ldetails.setId(idUpdated);
			detailsObj.deleteUser(details.getId());
		
			details =  detailsObj.saveUser(ldetails);
		}
		
		if(details == null) {
			log.info("Bad First Name & Last Name for Edit person details !! ");
			throw new Exception(" Bad First Name & Last Name for Edit person details ");
		}
		return details;
		
		
	}
	
	@PostMapping("/savedetails")
	@CrossOrigin(origins="http://localhost:4200")
	public PatientDetails saveDetails(@RequestBody PatientDetails ldetails) {
		PatientDetails details = null;
		details =  detailsObj.saveUser(ldetails);
		return details;
		
		
	}

	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail != null  && !tempEmail.equals("")) {
			User obj = serviceObj.fetchdetailslbyEmailId(tempEmail);
			if(obj != null) {
				log.info("User " +  tempEmail + "is already exists !!");
				throw new Exception("User " +  tempEmail + "is already exists !!");
			}
		}
		User obj = null;
		obj = serviceObj.saveUser(user);
		
		return obj;
		
	}
	
	@PostMapping("/loginuser")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		User userObj = null;
		
		if(tempEmail != null && tempPass !=null) {
	     	 userObj = serviceObj.fetchdetailslbyEmailIdAndPassword(tempEmail, tempPass);
	     	log.info("Good credentials !! " + userObj);
		}
		
		if(userObj == null) {
			log.info("Bad credentials !! ");
			throw new Exception("Bad credentials !!");
		}
		return userObj;

	}
}
