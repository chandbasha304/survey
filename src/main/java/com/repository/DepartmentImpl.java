package com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FixedStringValues;
import com.entity.Company;
import com.entity.Department;
import com.service.CompanyService;

import jakarta.persistence.EntityManager;

@Repository
public class DepartmentImpl {
	
	
	@Autowired
	private CompanyRepoData repoData;


	@Autowired
	private DepartmentData dept;

	@Autowired
	private CompanyService companySearch;





	@Autowired
	private EntityManager entityManager;

	public Object getDepartmentsByCompanyName(String companyName) {
		try {
			return entityManager.createQuery("SELECT d.departmentName,d.company.companyName  FROM Department d WHERE d.company.companyName = :companyName", Department.class)
					.setParameter("companyName", companyName)
					.getResultList();
		} finally {
			entityManager.close();
		}
	}



	public String saveNewDepartment(Map<String, Object> adg)

	{
		String companyName = (String)adg.get("companyName");


		Company company = companySearch.listOfCompanies.get(companyName.toLowerCase());
		int id = company.getCompanyId();
		Company company2 = entityManager.find(Company.class, id);
		String departmentName = (String) adg.get("department");
		System.out.println(departmentName+"***********");

		Department department = new Department(0, departmentName, company2);
		Department department2 = dept.save(department);
		return "Saved";
	}



	public List<Department> fetchingDepartments(String companyName) throws NullPointerException{
		
		
		
		List<Company> list = repoData.findByCompanyNameAndStatus(companyName,FixedStringValues.activeStatus);
		
		if(list.size()==1)
		{
			
			Company company = list.get(0);
			int companyId = company.getCompanyId();
			
			List<Department> list2 = dept.allDepartmentOfTheCompany(companyId);
			return list2;
			
			
		}
		return null;		
	}




}







