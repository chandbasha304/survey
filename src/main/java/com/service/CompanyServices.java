package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Company;
import com.entity.FetchCompany;
import com.errorshowing.UserInputError;
@Service
public interface CompanyServices {
	
	
	public List<Company> findCompanyDetails(FetchCompany data) throws UserInputError;

}
