package com.integra.demo.dto;

import java.util.List;

public class ProjectDTO {
	
	private Integer projectId;
	private String projectName;
	private String projectDesc;
	private String isDeleted;
	
	private List<EmployeeDTO> empDTOList;
	
	public List<EmployeeDTO> getEmpDTOList() {
		return empDTOList;
	}
	public void setEmpDTOList(List<EmployeeDTO> empDTOList) {
		this.empDTOList = empDTOList;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	
	
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	@Override
	public String toString() {
		return "ProjectDTO [projectId=" + projectId + ", projectName=" + projectName + ", projectDesc=" + projectDesc
				+ ", isDeleted=" + isDeleted + "]";
	}

	

}
