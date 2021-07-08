package com.tan.su.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="signUpTable")
public class SignUpCls {
	@Id
	private String accountNo;
	private String cif;
	private String branchCode;
	private String country;
	private String mobileNo;
	private String facilityRequired;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFacilityRequired() {
		return facilityRequired;
	}
	public void setFacilityRequired(String facilityRequired) {
		this.facilityRequired = facilityRequired;
	}
	
	
	
	
}
