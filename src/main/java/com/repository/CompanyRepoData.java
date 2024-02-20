package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.Company;
import java.util.List;


public interface CompanyRepoData extends JpaRepository<Company, Integer> {







	public List<Company> findByCompanyName(String companyName);
  
	
	public List<Company> findByCompanyNameAndStatus(String companyName,String status);
	
	
	@Query("select c from Company c where c.companyName like %:companyname%")
	public List<Company> findCompanyByQuery(@Param("companyname")String  companyname);

	
	@Query("select c from Company c where c.companyName like %:companyname% and c.status like :status")
	public List<Company> findCompanyAndStatusByQuery(@Param("companyname")String  companyname,@Param("status")String status);

	@Query("select c from Company c where c.status like :status")
	public List<Company> findByStatus(@Param("status")String status);
}
