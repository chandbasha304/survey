package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Company;
import com.entity.Department;
import com.repository.DepartmentImpl;

@Service
public class DepartmentService implements MainDepartment{
	
	
	@Autowired
	private DepartmentImpl departmentImpl;

	@Override
	public String saveDepartment(Map<String, Object> data) {
		

		

String string = departmentImpl.saveNewDepartment(data);


		return string;
	}

	@Override
	public List<Department> fetchAllDepartments(Map<String, Object> companyName)throws NullPointerException {

		String companyname = (String) companyName.get("companyName");
		
		List<Department> list = departmentImpl.fetchingDepartments(companyname);
		
		
		return list;
	}

}
