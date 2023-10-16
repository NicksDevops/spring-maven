/**
 * 
 */
package com.integra.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import com.google.gson.Gson;
import com.integra.demo.Exception.AppException;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.service.UserEmployeeService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;


@RestController
@RequestMapping(value = PathConstants.USER_EMPLOYEE)
public class UserEmployeeController 
{
	
	private static Logger log = Logger.getLogger(UserEmployeeController.class);
	
	@Autowired
	private UserEmployeeService userEmployeeService;
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
     private ViewResolver viewResolver;
	

	
//	-------------- Get User Employee Details -------------------
	@RequestMapping(value = PathConstants.USER_EMPLOYEE_VIEW, method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody  BaseResponseDTO viewEmployee(HttpServletRequest request, @PathVariable Integer empId)
	{
		log.info("[USEREmployeeController][viewEmployee]");
		
		BaseResponseDTO baseResponseDTO=null;
		EmployeeDTO employeeDTO = null;
		List<DepartmentDTO> deptDTOList = null;
		//log.info("Serial no - "+empId);
		//log.info("Employee DTO - "+empDTO);
		try
		{
			employeeDTO = userEmployeeService.getEmployeeBySerialNo(empId);
			deptDTOList = empService.getDepartmentDetails();
			
			Map<String,Object> map=new HashMap<String,Object>();
			Gson gson=new Gson();
			map.put("employeeDetai1", gson.toJson(employeeDTO));   //JSON.stringify()
			map.put("employeeData", employeeDTO);
			
			map.put("deptData", deptDTOList);
			
			//request.setAttribute("employee", employeeDTO);

			baseResponseDTO=new BaseResponseDTO();
			baseResponseDTO.setStatus(Common.SUCCESS_STATUS);
			baseResponseDTO.setRespBuffer(Common.resolveView(request, this.viewResolver,ViewConstants.USER_EMPLOYEE_VIEW, map));
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
	
		return baseResponseDTO;
	
	}
	
//	--------- UPDATE USER ---------------
	
	@RequestMapping(value = PathConstants.UPDATE_USER, method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BaseResponseDTO updateUser(@RequestBody EmployeeDTO employeeDTO) {
		log.info("[USEREmployeeController][updateUser]");

		BaseResponseDTO baseResponseDTO = null;
		try {
			baseResponseDTO = userEmployeeService.updateUser(employeeDTO);
			//baseResponseDTO = empService.updateEmployee(employeeDTO);

		} catch (AppException va) {
			log.error("[Error]", va);
			baseResponseDTO = Common.getFailureResponse(va.getErrorCode(), va.getErrorMessage(), null);

		} catch (Exception ex) {
			log.error("[Error]", ex);
			baseResponseDTO = 
					Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, Common.INTERNAL_SERVER_ERROR,null);

		}
		return baseResponseDTO;
	}
}


