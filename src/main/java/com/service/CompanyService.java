package com.service;

import com.entity.FetchCompany;
import com.errorshowing.UserInputError;
import com.repository.CompanyRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Company;

@Service
public class CompanyService implements CompanyServices{


	@Autowired
	private CompanyRepo companyRepo;


	public   Map<String, Company> listOfCompanies=getCompanyData();


	public static String cmpName;

	public List<Company> findCompanyDetails(FetchCompany data)throws UserInputError {

		System.out.println(data+"***********************");



		String companyname = data.getCompanyName();	

		String statusInLowercase = data.getStatus().toLowerCase();

		String actualName = companyname.toLowerCase();
		System.out.println(companyname+"*************Service Layer");
		String status = data.getStatus();

		System.out.println(status+"************status");


		if (!actualName.isEmpty() && !statusInLowercase.isEmpty()) 
		{
			List<Company> informationAndStatus = companyRepo.getCompanyInformationAndStatus(companyname, status);
			int recordOfcompany = informationAndStatus.size();
			if(recordOfcompany==1)
			{

				Company company = informationAndStatus.get(0);

				System.out.println(company+"*****************One Record Found");

				if(company.getStatus().equalsIgnoreCase("I"))
				{

					throw new UserInputError("Company Status Is InActive");
				}
				else
				{
					listOfCompanies.put(company.getCompanyName(), company);

				}
			}
			return informationAndStatus;
		}
		else if 
		(companyname.isEmpty() && status.isEmpty()) {
			throw new UserInputError("Provide User inputs");
		} 
		else if (companyname.isEmpty() && !status.isEmpty()) {
			List<Company> list = companyRepo.getCompaniesByStatus(status);

			for (Company company : list) {
				if(!company.getStatus().equalsIgnoreCase("I"))
				{listOfCompanies.put(company.getCompanyName(), company);}

			}
			return list;
		}

		else if (!companyname.isEmpty() && status.isEmpty()) {
			List<Company> list = companyRepo.getCompanyInformation(companyname);




			for (Company company : list) {
				if(!company.getStatus().equalsIgnoreCase("I"))
				{listOfCompanies.put(company.getCompanyName(), company);}

			}

			return list;
		}
		else {
			throw new UserInputError("Invalid Input Combination");
		} 
	}




	private Map<String, Company> getCompanyData() {



		Map<String, Company> dummyData = new HashMap<>();
		dummyData.put("value", null);
		return dummyData;
	}


	public String addingDepartmentsToCompany(String name)

	{

		for (Map.Entry<String, Company> entry : listOfCompanies.entrySet()) {
			String key = entry.getKey();
			Company val = entry.getValue();
			String companyname = entry.getValue().getCompanyName();



		}

		return null;
	}
}


