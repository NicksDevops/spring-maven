package com.integra.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= "employee")
public class EmployeeEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_no")
	private Integer serialNumber;
	
	@Column(name="emp_number")
	private Integer empNumber;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "education")
	private String edution;
	
	@Column(name = "address")
	private String address;
	
	
	@Column(name = "married")
	private String married;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_admin")
	private String isAdmin;
	
	@Column(name="is_deleted")
	private String isDeleted;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private DepartmentEntity department;
	
	
	@ManyToMany( cascade = 
				       { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
						CascadeType.REFRESH })
	@JoinTable(name = "employee_project", 
			   joinColumns = @JoinColumn(name = "employee_id"), 
			   inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<ProjectEntity> projectEntityList;

	
	public List<ProjectEntity> getProjectEntityList() {
		return projectEntityList;
	}

	public void setProjectEntityList(List<ProjectEntity> projectEntityList) {
		this.projectEntityList = projectEntityList;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEdution() {
		return edution;
	}

	public void setEdution(String edution) {
		this.edution = edution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}
	
	
	
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "EmployeeEntity [serialNumber=" + serialNumber + ", empNumber=" + empNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", edution="
				+ edution + ", address=" + address + ", married=" + married + ", password=" + password + ", isAdmin="
				+ isAdmin + ", isDeleted=" + isDeleted + ", department=" + department + "]";
	}

	//	--------------- Add Project --------------
	public void addProject(ProjectEntity projectEntity)
	{
		if(projectEntityList == null)
		{
			projectEntityList = new ArrayList<ProjectEntity>();
		}
		
		projectEntityList.add(projectEntity);
	}

	

	
	
}
