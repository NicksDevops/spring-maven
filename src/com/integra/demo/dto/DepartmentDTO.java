package com.integra.demo.dto;


public class DepartmentDTO {

	private Integer deptId;
	private String deptName;
	private String deptDescription;
	
	private String isDeleted;
	
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDescription() {
		return deptDescription;
	}
	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "DepartmentDTO [deptId=" + deptId + ", deptName=" + deptName + ", deptDescription=" + deptDescription
				+ ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
	
	

}
