package com.integra.demo.ServiceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.demo.Exception.ValidationException;
import com.integra.demo.dao.DepartmentDAO;
import com.integra.demo.dao.EmployeeDAO;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.service.DepartmentService;
import com.integra.demo.util.AppConstant;
import com.integra.demo.util.Common;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private EmployeeDAO empDAO;
	
	private static Logger log = Logger.getLogger(DepartmentServiceImpl.class);
	
	
//	--------------- Add DEPARTMENT ---------------
	@Override
	@Transactional
	public BaseResponseDTO addDepartment(DepartmentDTO departmentDTO) 
	{
		log.info("[DepartmentServiceImpl][addDepartment]");
		BaseResponseDTO baseResponseDTO=null;
		List<DepartmentDTO> deptDTOList = null;
		boolean val = true;
		
		try
		{
			
			// For empty fields
			if((departmentDTO.getDeptName()==null)|| (departmentDTO.getDeptName().trim()==""))
			{
				throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.DEPARTMENT_FIELDS_CANNOT_BE_NULL);
			}
			
			// to validate not to add duplicate departments
			deptDTOList = empDAO.getDepartmentDetails();
			
			for(DepartmentDTO deptDTO : deptDTOList)
			{
				if(departmentDTO.getDeptName().equalsIgnoreCase(deptDTO.getDeptName()))
				{
					val = false;
					break;
				}
			}
			
			if(val)
			{
				departmentDAO.addDepartment(departmentDTO);
				
				if(departmentDTO.getDeptId() == null ||  departmentDTO.getDeptId().equals(0))
				{
					throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS,AppConstant.DEPARTMENT_NOT_ADDED);
				}
				else
				{
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS,  AppConstant.DEPARTMENT_ADDED_SUCCESS , null);
				}
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.WARNING_STATUS,  AppConstant.DEPARTMENT_ALREADY_EXISTS , null);
			}

		}
		catch(ValidationException va)
		{
			log.error("Error : ",va);
			throw va;
			
		}
		catch(Exception ex)
		{
			log.error("Error : ",ex);
			throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS,  Common.INTERNAL_SERVER_ERROR);
			
		}
		
		return baseResponseDTO;
	}
	
//	---------------- UPDATE DEPARTMENT ------------------
	
	@Override
	@Transactional
	public BaseResponseDTO updateDepartment(DepartmentDTO departmentDTO)
	{
		log.info("[DepartmentServiceImpl][updateDepartment]");

		BaseResponseDTO baseResponseDTO=null;
		int id = 0;
		List<DepartmentDTO> deptList =  null;
		boolean val = true;

		try
		{
			// For empty fields
			if(((departmentDTO.getDeptId()== null) || departmentDTO.getDeptId().equals(0)) || 
					(departmentDTO.getDeptName()==null) || (departmentDTO.getDeptName().trim()==""))
			{
				throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.DEPARTMENT_FIELDS_CANNOT_BE_NULL);
			}
			
			// for duplicate departments 
			deptList = empDAO.getDepartmentDetails();
			for(DepartmentDTO department : deptList)
			{
				if(department.getDeptId() != departmentDTO.getDeptId())
				{
					if(department.getDeptName().equalsIgnoreCase(departmentDTO.getDeptName()))
					{
						val = false;
						break;
					}
				}
			}
			
			if(val)
			{
				id = departmentDAO.updateDepartment(departmentDTO);
				
				if(id == departmentDTO.getDeptId())
				{
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.DEPARTMENT_UPDATED, null);

				}
				else
				{
					baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, AppConstant.DEPARTMENT_NOT_UPDATED, null);
				}
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.WARNING_STATUS, AppConstant.DEPARTMENT_ALREADY_EXISTS, null);
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
	
//	---------- DELETE DEPARTMENT -------------
	
	@Override
	@Transactional
	public BaseResponseDTO deleteDepartment(int deptId)
	{
		log.info("[DepartmentServiceImpl][deleteDepartment]");
		
		String res = null;
		BaseResponseDTO baseResponseDTO=null;
		List<EmployeeDTO> empDTO = null;

		try
		{	
			empDTO = departmentDAO.getEmployeeDetail(deptId);
			
			if(empDTO.size()==0)
			{
				res = departmentDAO.deleteDepartment(deptId);
				
				if(res.equals("Y"))
				{
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.DEPARTMENT_DELETED, null);
				}
				else
				{
					baseResponseDTO = Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS,  AppConstant.DEPARTMENT_NOT_DELETED, null);
				}
			}
			else
			{
				baseResponseDTO = Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS,  AppConstant.DEPARTMENT_ASSOCIATED_WITH_EMPLOYEE, null);
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
		
		log.info("DElETE SUCCESSFULL.");
		return baseResponseDTO;
	}
}
