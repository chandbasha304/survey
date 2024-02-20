package com.entity;

public class CompanyData {

	
	
private String companyName;
	
	private String companydescription;
	
	private String status;

	public String getCompanyname() {
		return companyName;
	}

	public void setCompanyname(String companyname) {
		this.companyName = companyname;
	}

	public String getCompanydescription() {
		return companydescription;
	}

	public void setCompanydescription(String companydescription) {
		this.companydescription = companydescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CompanyData [companyname=" + companyName + ", companydescription=" + companydescription + ", status="
				+ status + "]";
	}

	public CompanyData(String companyname, String companydescription, String status) {
		super();
		this.companyName = companyname;
		this.companydescription = companydescription;
		this.status = status;
	}

	public CompanyData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	
}
