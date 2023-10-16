package com.integra.demo.dao;


import java.util.List;

import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.model.ProjectEntity;

public interface ProjectDAO {
	
	public ProjectDTO addProject(ProjectDTO projectDTO);
	
	public List<ProjectDTO> getProjectDetails();
	
	public int updateProject(ProjectDTO projectDTO);
	
	public String deleteProject(int projectId);
	
	public ProjectEntity getProject(int pID);
}
