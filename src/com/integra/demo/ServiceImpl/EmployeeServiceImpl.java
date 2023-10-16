/**
 * 
 */
package com.integra.demo.ServiceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.demo.Exception.ValidationException;
import com.integra.demo.dao.EmployeeDAO;
import com.integra.demo.dao.ProjectDAO;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.model.EmployeeEntity;
import com.integra.demo.model.ProjectEntity;
import com.integra.demo.service.EmployeeService;
import com.integra.demo.util.AppConstant;
import com.integra.demo.util.Common;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	ProjectDAO projectDAO;
	
	@Autowired
	HttpServletRequest request; 

	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);

	//	------------------ ADD EMPLOYEE ---------------------
	@Override
	@Transactional
	public BaseResponseDTO addEmployee(EmployeeDTO employeeDTO) {

		log.info("[EmployeeServiceImpl][addEmployee]");

		BaseResponseDTO baseResponseDTO=null;
		List<EmployeeDTO> empDTOList = null;
		boolean val = true;

		try
		{
			// for empty fields
			validateFields(employeeDTO.getFirstName(),employeeDTO.getLastName(),
					employeeDTO.getEmpNumber(),employeeDTO.getEdution(),employeeDTO.getGender(),
					employeeDTO.getAddress(), employeeDTO.getPassword(), employeeDTO.getMarried());
			
			// For duplicate employee Number
			empDTOList = employeeDAO.getEmployeeDetails();
			
			for(EmployeeDTO empDTO : empDTOList)
			{
				if(empDTO.getEmpNumber().equals(employeeDTO.getEmpNumber()))
				{
					val = false;
					break;
				}
			}
			
			if(val)
			{
				employeeDAO.addEmployee(employeeDTO);

				if(employeeDTO.getEmpNumber() == null || employeeDTO.getEmpNumber().equals(0))
				{
					throw new  ValidationException( BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_NOT_ADDED);

				}

				baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_ADDED_SUCCESSFULLY, null);
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.WARNING_STATUS, AppConstant.EMPLOYEE_NUMBER_ALREADY_PRESENT, null);
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

// ------------ GET DEPARTMENT DETAILS --------------
	@Override
	@Transactional
	public List<DepartmentDTO> getDepartmentDetails()
	{
		List<DepartmentDTO> deptList =	employeeDAO.getDepartmentDetails();

		return deptList;
	}

//	------------GET EMPLOYEE DETAILS ----------------
	
	@Override
	@Transactional
	public List<EmployeeDTO> getEmployeeDetails()
	{
		log.info("[EmployeeServiceImpl][getEmployeeDetails()]");
		List<EmployeeDTO> empList = employeeDAO.getEmployeeDetails();

		return empList;
	}
	
	
//	------------- UPDATE EMPLOYEE DETAILS ---------------
	
	@Override 
	@Transactional
	public BaseResponseDTO updateEmployee(EmployeeDTO employeeDTO)
	{
		log.info("[EmployeeServiceImpl][updateEmployee]");

		BaseResponseDTO baseResponseDTO=null;
		int numberOfRows = 0;
		List<EmployeeDTO> empList = null;

		try
		{	
			// For empty fields
			validateFields(employeeDTO.getFirstName(),employeeDTO.getLastName(),
					employeeDTO.getEmpNumber(),employeeDTO.getEdution(),employeeDTO.getGender(),
					employeeDTO.getAddress(), employeeDTO.getPassword(), employeeDTO.getMarried());
			
			
//		EmployeeDTO emp = (EmployeeDTO)	request.getSession().getAttribute("empData");
//		log.info("Employee logged in - from Session : "+emp);
//			
//		if(emp.getSerialNumber().equals(employeeDTO.getSerialNumber()))
//		{
//			throw new ValidationException(BaseResponseDTO.WARNING_STATUS, AppConstant.ADMIN_CANNOT_UPDATE_HIMSELF);
//		}
		
			numberOfRows = employeeDAO.updateEmployee(employeeDTO);
			
		//log.info("Rows -----> "+ numberOfRows);
			
			if(numberOfRows >0)
			{
				baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_UPDATED, null);
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_NOT_UPDATED, null);
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
	

//	-------------- DELETE EMPLOYEE ---------------

	@Override
	@Transactional
	public BaseResponseDTO deleteEmployee(int empNumber)
	{
		log.info("[EmployeeServiceImpl][deleteEmployee]");

		BaseResponseDTO baseResponseDTO=null;
		String res = null;
		EmployeeDTO employeeDTO = null;

		try
		{	
			employeeDTO = employeeDAO.getEmployeeBYEmpNumber(empNumber);
			if(employeeDTO.getIsAdmin().equals("Y"))
			{
				throw new  ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.ADMIN_CANNOT_BE_DELETE);
			}
			
			res = employeeDAO.deleteEmployee(empNumber);

			if(res.equals("Y"))
			{
				baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_DELETE, null);
			}
			else
			{
				baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_NOT_DELETE, null);
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
	
//	------------------ ASSIGN PROJECT -------------------
	
	@Override
	@Transactional
	public BaseResponseDTO assignProject(int slNo, int pId)
	{
		log.info("[EmployeeServiceImpl][assignProject]");

		BaseResponseDTO baseResponseDTO=null;
		
		EmployeeEntity empEntity = null;
		ProjectEntity projectEntity = null;
		List<ProjectEntity> projectList = null;
		boolean val = true;
	
		try
		{	
			empEntity = employeeDAO.getEmployee(slNo);
			projectEntity = projectDAO.getProject(pId);
			
			log.info("Employee - "+empEntity);
			log.info("Project - "+projectEntity);
			
			projectList = empEntity.getProjectEntityList();	
			for(ProjectEntity project : projectList)
			{
				if(pId==project.getProjectId())
				{
					val =false;
					break;
				}
			}
			
			
			if(val)
			{
				if(empEntity!=null && projectEntity!=null)
				{
					empEntity.addProject(projectEntity);
					
					employeeDAO.assignProject(empEntity);
					
					baseResponseDTO=Common.getSuccessResponse(BaseResponseDTO.SUCCESS_STATUS, AppConstant.EMPLOYEE_ASSIGNED, null);
					
				}
				else
				{
					baseResponseDTO=Common.getFailureResponse(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_NOT_ASSIGNED, null);

				}
			}
			else
			{
				throw new  ValidationException(BaseResponseDTO.WARNING_STATUS, AppConstant.EMPLOYEE_ALRESDY_ASSIGNED);
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
	
	
	
	@Override
	@Transactional
	public List<EmployeeDTO> getEmProjectDetails()
	{
		return employeeDAO.getEmProjectDetails();
	}

	
//--------------Method to Validate ----------
	
	static private void validateFields(String firstName, String lastName, Integer empNumber, String edution, String gender, String adress, String password, String married )
	{
	
		if((firstName.trim()==""||firstName==null) || (lastName.trim()==""||lastName==null))
		{
			throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_FIELDS_CANNOT_BE_EMPTY);
		}
		else if(empNumber==0||empNumber.equals(0))
		{	
			throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_FIELDS_CANNOT_BE_EMPTY);
		}
		else if((edution.trim()==""||edution==null)|| (gender.trim()==""||gender==null))
		{
			throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_FIELDS_CANNOT_BE_EMPTY);
		}
		else if((adress.trim()==""||adress==null) || (married.trim()==""||married==null) || (password.trim()==""||password==null))
		{
			throw new ValidationException(BaseResponseDTO.FAILURE_STATUS, AppConstant.EMPLOYEE_FIELDS_CANNOT_BE_EMPTY);
		}
		
		
	}
	
}
