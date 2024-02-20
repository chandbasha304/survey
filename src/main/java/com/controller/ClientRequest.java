package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Company;
import com.entity.CompanyData;
import com.entity.Department;
import com.entity.FetchCompany;
import com.errorshowing.UserInputError;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.repository.CompanyRepoData;
import com.repository.DepartmentData;
import com.repository.DepartmentImpl;
import com.service.CompanyService;
import com.service.CompanyServices;
import com.service.MainDepartment;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClientRequest {




	@Autowired
	private CompanyService companyService;


	@Autowired
	private MainDepartment mainDepartment;

	@Autowired
	private CompanyServices companyServices;


	@Autowired
	private DepartmentImpl savingData;


	@Autowired
	private DepartmentData adk;



	@Autowired
	private CompanyRepoData csData;




	@GetMapping("/hi")
	public String getview()
	{

		return "Hello Brother";
	}



	@PostMapping("/companybio")
	public ResponseEntity<Object> getDetails(@RequestBody FetchCompany data)
	{

		System.out.println(data+"FROM REACT Application***********88");

		try {
			List<Company> company = companyServices.findCompanyDetails(data);
			System.out.println(companyService.listOfCompanies+"*********************8");
			System.out.println(companyService.listOfCompanies.size()+"*********");

			if(company.size()==0)
			{

				return ResponseEntity.ok("No Data Found");	
			}

			CompanyData companyData = new CompanyData();
			BeanUtils.copyProperties(company, companyData);
			System.out.println(companyData);
			Map<String,Company> listOfCompanies = companyService.listOfCompanies;

			System.out.println(listOfCompanies+"*******************InMemory Database");

			return ResponseEntity.ok(company);


		} 


		catch (UserInputError e) {


			return ResponseEntity.ok(e.getMessage());
		}

		catch (Exception e) {


			return ResponseEntity.ok("Status Is InActive"+e.getMessage());
		}
	}




	@GetMapping("/all")
	public List<Company> getAllCompanyInformation()
	{  

		System.out.println("Invoke Method");

		List<Company> list = csData.findAll();

		System.out.println(list.size()+"Rows************");
		return list;
	}


	@PostMapping("/addept")
	public String saveData(@RequestBody Map<String, Object> data)
	{

		String string = mainDepartment.saveDepartment(data);


		return string;	
	}


	@PostMapping("/alldepartment")
	public Object addDepartment(@RequestBody Map<String, Object> companyName)
	{
		
		try
		{

List<Department> list = mainDepartment.fetchAllDepartments(companyName);

		return list;
		}
		catch (NullPointerException e) {
			return e.getMessage();
		}
		
		catch (Exception e) {
			
			return e.getMessage();
		}
	}

	@PostMapping("/lists")
	public List<Department> getAllDepartmentData(@RequestBody Map<String, Object> data)
	{
		List<Department> all = adk.findAll();



		return all;
	}


}
