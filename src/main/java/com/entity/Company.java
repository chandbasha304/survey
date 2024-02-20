package  com.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="companyid")
    private int companyId;
    @Column(name="companyname" ,nullable = false)
    private String companyName;
    @Column(name="companydescription")
    private String companyDescription;
    @Column(name="status")
    private String status;

    @OneToMany(mappedBy = "company",orphanRemoval = true,targetEntity = Department.class)
    @JsonIgnore
    private List<Department> departments;

    public Company() {
    }

    public Company(int companyId, String companyName, String companyDescription, String status,
			List<Department> departments) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.status = status;
		this.departments = departments;
	}

	public Company(String companyName, String companyDescription, String status) {
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.status = status;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyDescription=" + companyDescription + ", status=" + status + "]";
    }
}
