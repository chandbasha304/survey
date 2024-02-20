package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "departmentsample")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentid")
	private int departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id", referencedColumnName = "companyId")
	private Company company;

	// Getters and setters

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", company="
				+ company + "]";
	}

	public Department() {
		super();
	}

	public Department(int departmentId, String departmentName, Company company) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.company = company;
	}




}
