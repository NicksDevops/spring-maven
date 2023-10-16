package com.integra.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;

import com.integra.demo.Exception.AppException;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.service.ProjectService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;

@RestController
@RequestMapping(value = PathConstants.PROJECT)
public class ProjectController {

	private static Logger log = Logger.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectService;



	//  --------- VIEW PROJECT FORM ---------------
	@Autowired
	private ViewResolver viewResolver;


	@RequestMapping(value = PathConstants.ADD_PROJECT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO showProject(HttpServletRequest request)
	{
		log.info("[ProjectController][addProject]");
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			Map<String,Object> map=new HashMap<String,Object>();
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.ADD_PROJECT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}

		return baseResponseDTO;

	}	

	//	------------- GET PROJECT DETAILS -----------------
	@RequestMapping(value = PathConstants.VIEW_PROJECT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO viewProject(HttpServletRequest request )
	{
		log.info("[ProjectController][getProjectDetails]");
		BaseResponseDTO baseResponseDTO=null;
		List<ProjectDTO> projectList = null;
		try
		{
			projectList = projectService.getProjectDetails();

			Map<String,Object> map=new HashMap<String,Object>();

			map.put("projectDetails", projectList);

			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.VIEW_PROJECT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		log.info("Project Details : "+projectList);
		return baseResponseDTO;

	}

	//	-------------------- Add Project Details -----------------------------------------

	@RequestMapping(value = PathConstants.ADD_Project_POST, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO addProject(@RequestBody ProjectDTO projectDTO) 
	{
		log.info("[ProjectController][addProjectPost]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=projectService.addProject(projectDTO);

		}
		catch(AppException va) 
		{
			log.error("[Error]",va);
			baseResponseDTO=Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(),null);

		}
		catch(Exception ex)
		{
			log.error("[Error]",ex);
			baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR,null);

		}
		return baseResponseDTO;

	}


	//	------------ UPDATE PROJECT -------------

	@RequestMapping(value = PathConstants.UPDATE_PROJECT, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO updateProject(@RequestBody ProjectDTO projectDTO) 
	{
		log.info("[ProjectController][updateProject]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=projectService.updateProject(projectDTO);

		}
		catch(AppException va) 
		{
			log.error("[Error]",va);
			baseResponseDTO=Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(), null);

		}
		catch(Exception ex)
		{
			log.error("[Error]",ex);
			baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR, null);

		}
		return baseResponseDTO;

	}

	//	--------------- DELETE PROJECT -----------------

	@RequestMapping(value = PathConstants.DELETE_PROJECT, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO deleteProject(@RequestBody ProjectDTO projectDTO)
	{
		log.info("[ProjectController][deleteProject]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO = projectService.deleteProject(projectDTO.getProjectId());

		}
		catch(AppException va) 
		{
			log.error("[Error]",va);
			baseResponseDTO=Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(), null);

		}
		catch(Exception ex)
		{
			log.error("[Error]",ex);
			baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR, null);

		}
		
		log.info("Delete Success");
		
		return baseResponseDTO;
	}

}
