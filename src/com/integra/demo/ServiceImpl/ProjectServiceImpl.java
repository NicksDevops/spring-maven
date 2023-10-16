package com.integra.demo.ServiceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.demo.Exception.AppException;
import com.integra.demo.Exception.ValidationException;
import com.integra.demo.dao.ProjectDAO;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.service.ProjectService;
import com.integra.demo.util.AppConstant;
import com.integra.demo.util.Common;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	private static Logger log = Logger.getLogger(ProjectServiceImpl.class);
	
	
//	---------------- GET PROJECT DETAILS ----------------------
	
	@Override
	public List<ProjectDTO> getProjectDetails()
	{
		log.info("[ProjectServiceImpl][getProjectDetails]");
		
		List<ProjectDTO> projectSTOList =   projectDAO.getProjectDetails();
		
		return projectSTOList;
	}
	
	
//	-------------ADD PROJECT DETAILS -----------------
	@Override
	@Transactional
	public BaseResponseDTO addProject(ProjectDTO projectDTO) {
		
		log.info("[ProjectServiceImpl][addProject]");
		
		BaseResponseDTO baseResponseDTO=null;
		boolean val = true;
		
		try
		{
//			For empty fields
			if(((projectDTO.getProjectName()==null)|| (projectDTO.getProjectName().trim()=="")))
				{
					throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS,AppConstant.PROJECT_FIELDS_CANNOT_BE_NULL);
				}
			
			
//			For duplicate project fields
			List<ProjectDTO> projectSTOList =   projectDAO.getProjectDetails();
			for(ProjectDTO  project : projectSTOList)
			{
				if(project.getProjectName().equalsIgnoreCase(projectDTO.getProjectName()) )
				{
					val = false;
					break;
				}
			}
			
			if(val)
			{
				projectDAO.addProject(projectDTO);
				
				if(projectDTO.getProjectId() == null ||  projectDTO.getProjectId().equals(0))
				{
					throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS,AppConstant.PROJECT_NOT_ADDED);
					
				}
				else
				{
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.PROJECT_ADDED_SUCCESS, null);
				}
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.WARNING_STATUS, AppConstant.PROJECT_ALREADY_EXISTS, null);
			}
			
			
			
		}
		catch(ValidationException va)
		{
			log.error("Error : ",va);
			throw va;
			
		}
		catch(Exception ex)
		{
			log.error(ex);
			
			throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR);
			
		}
		
		return baseResponseDTO;
	}
	
//	------------ UPDATE PROJECT DETAILS ---------------
	
	@Override
	@Transactional
	public BaseResponseDTO updateProject(ProjectDTO projectDTO)
	{
		log.info("[ProjectServiceImpl][updateProject]");

		BaseResponseDTO baseResponseDTO=null;
		int id = 0;
		List<ProjectDTO> projectList = null;
		boolean val = true;

		try
		{
//			For empty fields
			if((projectDTO.getProjectId()==null||projectDTO.getProjectId().equals(0) || 
					((projectDTO.getProjectName()==null) || (projectDTO.getProjectName().trim()==""))))
			{
				throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS,AppConstant.PROJECT_FIELDS_CANNOT_BE_NULL);
			}
			
//			 for duplicate project fields
			projectList = projectDAO.getProjectDetails();
			for(ProjectDTO project : projectList)
			{
				if(project.getProjectId()!=projectDTO.getProjectId())
				{
					if(project.getProjectName().equalsIgnoreCase(projectDTO.getProjectName()))
					{
						val = false;
						break;
					}
				}
			}
			
			if(val)
			{
				id = projectDAO.updateProject(projectDTO);
				
				if(id==projectDTO.getProjectId())
				{
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.PROJECT_UPDATED, null);
				}
				else
				{
					baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.PROJECT_NOT_UPDATED, null);

				}
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.WARNING_STATUS, AppConstant.PROJECT_ALREADY_EXISTS, null);
			}
			
			
		}
		catch(ValidationException va)
		{
			log.error("Error : ",va);
			throw va;

		}
		catch(Exception ex)
		{
			log.error(ex);

			throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR);

		}

		return baseResponseDTO;
	}
	
	
//	----------------- DELETE PROJECT -----------------
	
	@Override
	@Transactional
	public BaseResponseDTO deleteProject(int projectId)
	{
		log.info("[ProjectServiceImpl][deleteProject]");

		BaseResponseDTO baseResponseDTO=null;
		String res = null;

		try
		{
			res = projectDAO.deleteProject(projectId);
			
			if(res.equals("Y"))
			{
				baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.PROJECT_DELETED, null);
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, AppConstant.PROJECT_NOT_DELETED, null);

			}
		}
		catch(ValidationException va)
		{
			log.error("Error : ",va);
			throw va;

		}
		catch(Exception ex)
		{
			log.error("Exception : ",ex);

			throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR);

		}
		
		return baseResponseDTO;
	}

}
