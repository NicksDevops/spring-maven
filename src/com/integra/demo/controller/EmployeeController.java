/**
 * 
 */
package com.integra.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import com.integra.demo.Exception.AppException;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;


@RestController
@RequestMapping(value = PathConstants.EMPLOYEE)
public class EmployeeController 
{
	
	private static Logger log = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
     private ViewResolver viewResolver;
	
//	-------------------- View EMPLOYEE FORM -----------------
	
	@RequestMapping(value = PathConstants.REQ_EMPLOYEE, method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO reqEmployee(HttpServletRequest request)
	{
		log.info("[EmployeeController][reqEmployee]");
		BaseResponseDTO baseResponseDTO=null;
		
		List<DepartmentDTO> deptList = null;
		try
		{
			deptList = employeeService.getDepartmentDetails();
			
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("deptData", deptList);
			
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.ADD_EMPLOYEE, map));
		}
		catch (Exception e) {
			
			log.info("Exception Occurred : "+e);
		}
		
		log.info("Department Lit : "+deptList);
		
		
		return baseResponseDTO;
		
	}
	
//	-------------- Get Employee Details -------------------
	@RequestMapping(value = PathConstants.VIEW_EMPLOYEE, method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO viewEmployee(HttpServletRequest request )
	{
		log.info("[EmployeeController][viewEmployee]");
		
		BaseResponseDTO baseResponseDTO=null;
		
		List<EmployeeDTO> empList = null;
		List<DepartmentDTO> deptList = null;
		try
		{
			 empList = employeeService.getEmployeeDetails();
			 
			 deptList = employeeService.getDepartmentDetails();
			
			Map<String,Object> map=new HashMap<String,Object>();
			
			map.put("employeeList",empList);
			
			map.put("deptData", deptList);
			
			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.VIEW_EMPLOYEE, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		
		log.info("Employee List : "+empList);
		
		return baseResponseDTO;
		
	}
	
//	--------------------Add Employee -------------------------
	
	@RequestMapping(value = PathConstants.SHOW_EMPLOYEE_POST, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) 
	{
		log.info("[EmployeeController][showEmployeePost]");
		
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=employeeService.addEmployee(employeeDTO);
			
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
	
	
//	---------- DELETE EMPLOYEE DETAILS --------------
	
	@RequestMapping(value = PathConstants.DELETE_EMPLOYEE, method = RequestMethod.POST, 
							consumes = MediaType.APPLICATION_JSON_VALUE, 
							produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO deleteEmployee(@RequestBody EmployeeDTO empDTO) 
	{
		log.info("[EmployeeController][deleteEmployee]");
		
		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=employeeService.deleteEmployee(empDTO.getEmpNumber());
			
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
	
	
//	-------------UPDATE EMPLOYEE DETAILS ----------------
	
	@RequestMapping(value = PathConstants.UPDATE_EMPLOYEE, method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		log.info("[EmployeeController][updateEmployee]");

		BaseResponseDTO baseResponseDTO=null;
		try
		{
			baseResponseDTO=employeeService.updateEmployee(employeeDTO);

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

