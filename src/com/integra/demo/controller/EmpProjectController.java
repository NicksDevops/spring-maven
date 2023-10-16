package com.integra.demo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;

import com.integra.demo.Exception.AppException;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.service.ProjectService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;

@RestController
@RequestMapping(value=PathConstants.emp_PROJECT)
public class EmpProjectController {
	
	private static Logger log = Logger.getLogger(EmpProjectController.class);

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ProjectService projectService;

	@Autowired
	private ViewResolver viewResolver;

// ------- SHow FORM-------------
	@RequestMapping(value = PathConstants.ASSIGN_PROJECT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO assignProject(HttpServletRequest request)
	{
		log.info("[EmpProjectController][AssignProject]");
		BaseResponseDTO baseResponseDTO=null;
		List<EmployeeDTO> empList = null;
		List<ProjectDTO> projectList = null;
		
		try
		{
			empList = employeeService.getEmployeeDetails();
			projectList = projectService.getProjectDetails();
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("employeeList", empList);
			map.put("projectList", projectList);
			
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.ASSIGN_PROJECT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		//		log.info("Testing add End");
		return baseResponseDTO;

	}
	
//	------------   VIEW ASSIGN TABLE --------------  
	@RequestMapping(value = PathConstants.VIEW_EMP_PROJECT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO viewEmpProjectts(HttpServletRequest request)
	{
		log.info("[EmpProjectController][View Assign Table]");
		BaseResponseDTO baseResponseDTO=null;
		List<EmployeeDTO> empList = null;
		
		try
		{
			empList = employeeService.getEmProjectDetails();
			
			for (EmployeeDTO employeeDTO : empList) {
				
				log.info("--->"+employeeDTO);
				log.info("-->"+employeeDTO.getProjectDTOList());
			}
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("empList", empList);
			
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.VIEW_EMP_PROJECT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		//		log.info("Testing add End");
		return baseResponseDTO;

	}
	
//	------------ ASSIGN PROJECT TO EMPLOYEE ---------
	
	@RequestMapping(value = PathConstants.ASSIGN_PROJECT_POST, method = RequestMethod.POST, 
							consumes = MediaType.APPLICATION_JSON_VALUE, 
							produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO addEmpProject(@RequestBody EmployeeDTO employeeDTO) 
	{
		log.info("[EmpProjectController][Assign Project Assign]");
		//log.info(employeeDTO);
		log.info("EmployeeDTO--"+employeeDTO.getSerialNumber()+"-- and --"+ employeeDTO.getProjectId());
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=employeeService.assignProject(employeeDTO.getSerialNumber(), employeeDTO.getProjectId());
			
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
}
