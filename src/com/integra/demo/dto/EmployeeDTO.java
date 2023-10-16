
package com.integra.demo.dto;

import java.util.List;

import com.integra.demo.model.DepartmentEntity;

public class EmployeeDTO {

	private Integer serialNumber;
	private Integer empNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String edution;
	private String address;
	private String married;
	private String password;
	private String isAdmin;
	
	private Integer dept_id;
	
	private String isDeleted;
	
	private DepartmentDTO deptDTO;
	
	private List<ProjectDTO> projectDTOList;
	
	private Integer projectId;
	
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public List<ProjectDTO> getProjectDTOList() {
		return projectDTOList;
	}

	public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
		this.projectDTOList = projectDTOList;
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

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public DepartmentDTO getDeptDTO() {
		return deptDTO;
	}

	public void setDeptDTO(DepartmentDTO deptDTO) {
		this.deptDTO = deptDTO;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [serialNumber=" + serialNumber + ", empNumber=" + empNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", edution="
				+ edution + ", address=" + address + ", married=" + married + ", password=" + password + ", isAdmin="
				+ isAdmin + ", dept_id=" + dept_id + ", isDeleted=" + isDeleted + ", deptDTO=" + deptDTO
				+ ", projectId=" + projectId + "]";
	}

	
}
