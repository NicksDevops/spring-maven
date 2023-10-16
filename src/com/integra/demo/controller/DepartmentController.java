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
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.DepartmentService;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;

@RestController
@RequestMapping(value=PathConstants.DEPT)
public class DepartmentController {

	private static Logger log = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	private ViewResolver viewResolver;

	//	---------------Get Department Form ---------------

	@RequestMapping(value = PathConstants.ADD_DEPARTMENT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO showDepartment(HttpServletRequest request)
	{
		log.info("[DepartmentController][showDepartment]");
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			Map<String,Object> map=new HashMap<String,Object>();
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.ADD_DEPARTMENT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		//		log.info("Testing add End");
		return baseResponseDTO;

	}

	//	-------------Add Department---------------
	@RequestMapping(value = PathConstants.ADD_DEPTPOST, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) 
	{
		log.info("[DepartmentController][postAdd]");
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=departmentService.addDepartment(departmentDTO);


		}
		catch(AppException va) 
		{
			log.error("[Error]",va);
			baseResponseDTO=Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(), null);

		}
		catch(Exception ex)
		{
			log.error("[Error]",ex);
			baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS , Common.INTERNAL_SERVER_ERROR, null);

		}
		return baseResponseDTO;

	}


	//	------------------------- GET DEPARTMENT DETAILS -------------------------

	@RequestMapping(value = PathConstants.VIEW_DEPARTMENT, method= RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO viewDepartment(HttpServletRequest request)
	{
		log.info("[DepartmentController][viewDepartment]");
		BaseResponseDTO baseResponseDTO=null;
		List<DepartmentDTO> deptList = null;
		try
		{
			deptList = employeeService.getDepartmentDetails();

			Map<String,Object> map=new HashMap<String,Object>();

			map.put("departmentList", deptList);
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.VIEW_DEPARTMENT, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		log.info("Department List : "+deptList);
		return baseResponseDTO;

	}

	//	-------------------- UPDATE DEPARTMENT DETAILS --------------

	@RequestMapping(value = PathConstants.UPDATE_DEPARTMENT, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody BaseResponseDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO)
	{
		log.info("[DepartmentController][updateDepartment]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=departmentService.updateDepartment(departmentDTO);

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
	
//	-------------- DELETE DEPARTMENT -----------------
	
	@RequestMapping(value = PathConstants.DELETE_DEPARTMENT, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO deleteDept(@RequestBody DepartmentDTO deptDTO)
	{
		log.info("[DepartmentController][deleteDept]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO = departmentService.deleteDepartment(deptDTO.getDeptId());

		}
		catch(AppException va) 
		{
			log.error("[Error]",va);
			baseResponseDTO=Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(),null);

		}
		catch(Exception ex)
		{
			log.error("[Error]",ex);
			baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR, null);

		}
		
		return baseResponseDTO;
	}


}
