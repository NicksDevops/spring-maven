package com.integra.demo.ServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.demo.Exception.ValidationException;
import com.integra.demo.dao.EmployeeDAO;
import com.integra.demo.dao.UserEmpDAO;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.UserEmployeeService;
import com.integra.demo.util.AppConstant;
import com.integra.demo.util.Common;

@Service
public class UserEmployeeServiceImpl implements UserEmployeeService {
	
	Logger log = Logger.getLogger(UserEmployeeServiceImpl.class);
	
	@Autowired
	UserEmpDAO userEmpDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	
//	------------ getEmployeeByPasswordAndEmpNumber ------------
	@Override
	@Transactional
	public EmployeeDTO getEmployeeByPasswordAndEmpNumber(int empNumber, String password) {
		
		log.info("[UserEmployeeServiceImpl][getEmployeeByPasswordAndEmpNumber]");

		EmployeeDTO employeeDTO = null;
		try {
			
			employeeDTO = userEmpDAO.getEmployeeByPasswordAndEmpNumber(empNumber, password);
			
		} 
		catch (Exception e) {
			
			log.error("Exception is : ",e);
			throw e;
		}
		
		return employeeDTO;
	}
	
//	------------- getEmployeeBySerialNo --------------
	@Override
	@Transactional
	public EmployeeDTO getEmployeeBySerialNo(int slNo)
	{
		log.info("[UserEmployeeServiceImpl][getEmployeeBySerialNo]");

		EmployeeDTO empDTO = null;
		
		try 
		{
			empDTO = userEmpDAO.getEmployeeBySerialNo(slNo);
		} 
		catch (Exception e) 
		{
			log.error("Exception is : ",e);
			throw e;
		}
		
		return empDTO;
	}
	
//	--------------UPDATE USER ---------
	
	@Override 
	@Transactional
	public BaseResponseDTO updateUser(EmployeeDTO employeeDTO)
	{
		log.info("[UserEmployeeServiceImpl][updateUser]");

		BaseResponseDTO baseResponseDTO=null;
		int rowsUpdated = 0;

		try
		{
//			rowsUpdated = userEmpDAO.updateUser(employeeDTO);
			rowsUpdated = employeeDAO.updateEmployee(employeeDTO);

			if(rowsUpdated >0)
			{
				baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_UPDATED, null);
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_NOT_UPDATED, null);
			}
			

			//baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_UPDATED, null);
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

}
