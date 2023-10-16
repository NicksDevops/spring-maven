package com.integra.demo.service;

import java.util.List;

import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.ProjectDTO;

public interface ProjectService {
	
	public BaseResponseDTO addProject(ProjectDTO projectDTO);
	
	public List<ProjectDTO> getProjectDetails();
	
	public BaseResponseDTO updateProject(ProjectDTO projectDTO);
	
	public BaseResponseDTO deleteProject(int projectId);
	
}
