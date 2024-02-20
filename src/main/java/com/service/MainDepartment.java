package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.entity.Company;
import com.entity.Department;
@Service
public interface MainDepartment {
	
	
	
	public String saveDepartment(Map<String, Object> data);

	public List<Department> fetchAllDepartments(Map<String, Object> companyName);

}
