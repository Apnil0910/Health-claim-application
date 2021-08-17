package com.app.healthclaim.healthapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientDetails {

	@Override
	public String toString() {
		return "PatientDetails >>>> [id=" + id + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", email=" + email + ", contactno=" + contactno + ", dob=" + dob + ", state=" + state + ", country="
				+ country + ", totalBillAmt=" + totalBillAmt + ", dateofAdmission=" + dateofAdmission
				+ ", dateofDischarge=" + dateofDischarge + ", providerName=" + providerName + ", panNo=" + panNo + "]";
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String address;
	private String email;
	private int contactno ;
	private String dob ;
	private String state ;
	private String country ;
	private String totalBillAmt;
	private String dateofAdmission ;
	private String dateofDischarge ;
	private String providerName;
	private String panNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactno() {
		return contactno;
	}
	public void setContactno(int contactno) {
		this.contactno = contactno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTotalBillAmt() {
		return totalBillAmt;
	}
	public void setTotalBillAmt(String totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}
	public String getDateofAdmission() {
		return dateofAdmission;
	}
	public void setDateofAdmission(String dateofAdmission) {
		this.dateofAdmission = dateofAdmission;
	}
	public String getDateofDischarge() {
		return dateofDischarge;
	}
	public void setDateofDischarge(String dateofDischarge) {
		this.dateofDischarge = dateofDischarge;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	public PatientDetails(int id, String fname, String lname, String address, String email, int contactno, String dob,
			String state, String country, String totalBillAmt, String dateofAdmission, String dateofDischarge,
			String providerName, String panNo) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.contactno = contactno;
		this.dob = dob;
		this.state = state;
		this.country = country;
		this.totalBillAmt = totalBillAmt;
		this.dateofAdmission = dateofAdmission;
		this.dateofDischarge = dateofDischarge;
		this.providerName = providerName;
		this.panNo=panNo;
	}
	public PatientDetails() {
	
	}
	
}
