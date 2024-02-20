package com.entity;

public class FetchCompany {
	
	
	





	private String companyName;
	
	
	
	private String status;



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "FetchCompany [companyName=" + companyName + ", status=" + status + "]";
	}



	public FetchCompany(String companyName, String status) {
		super();
		this.companyName = companyName;
		this.status = status;
	}



	public FetchCompany() {
		super();
		// TODO Auto-generated constructor stub
	}





}
