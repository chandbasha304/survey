package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Company;

@Repository
public class CompanyRepo {


	@Autowired 
	private CompanyRepoData company;

	public List<Company> getCompanyInformation(String companyName) {




		List<Company> list = company.findCompanyByQuery(companyName);


		System.out.println(list+"   By CompanyName Using Query*******************************");

		return list;


	} 


	public List<Company> getCompanyInformationAndStatus(String companyName,String status) throws NullPointerException{


		//		 ArrayList<String> statusMessage = new ArrayList<>();
		System.out.println("Repo Layer************************");
 List<Company> query = company.findCompanyAndStatusByQuery(companyName, status);
 

		//			 if(!status.equalsIgnoreCase("A"))
		//			 {
		//				 
		//				 
		//				 return statusMessage;
		//			 }




		System.out.println(query+"Using Company Name ad Status***************From DataBase");

		return query;


	}


	public List<Company> getCompaniesByStatus(String status) {
		List<Company> byStatus = company.findByStatus(status);
		System.out.println(byStatus +"***************************Only Status");

		return byStatus;
	} 

}
