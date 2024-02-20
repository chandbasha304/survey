package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Company;
import com.entity.Department;
@Repository
public interface DepartmentData extends JpaRepository<Department, Integer> 
{

	

	
	
	@Query("select d from Department d where d.company.companyId=:id ")
	List<Department> allDepartmentOfTheCompany(@Param("id")int id);
	
	
}
