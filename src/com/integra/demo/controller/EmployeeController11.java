/**
 * 
 */
package com.integra.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;

/**
 * @author Keerteewerulkar
 *
 */
@RestController
@RequestMapping(value = PathConstants.EMPLOYEE)
public class EmployeeController11 {
	
	private static Logger log = Logger.getLogger(EmployeeController11.class);
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = PathConstants.EMPLOYEE, method= RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
	public  ModelAndView addEmployee(@RequestBody EmployeeDTO employeeDTO)
	{
		try
		{
			log.info("Testing add start : " +employeeDTO);
			if(employeeDTO != null)
			{
				employeeService.addEmployee(employeeDTO);
			}
			else
			{
				log.info("Employee information is not present.");
			}
		}
		catch (Exception e) {
			log.info("Exception Occurred : "+e);
		}
		log.info("Testing add End");
		return new ModelAndView(ViewConstants.SUCCESSFUL_PAGE);
		
	}
}
