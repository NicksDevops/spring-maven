package com.integra.demo.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.integra.demo.dao.UserEmpDAO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.model.DepartmentEntity;
import com.integra.demo.model.EmployeeEntity;
import com.integra.demo.util.Common;

@Repository
public class UserEmpDAOImpl implements UserEmpDAO {
	
	@PersistenceContext
	EntityManager entityManager;

//	--------- getEmployeeByPasswordAndEmpNumber --------------
	@Override
	public EmployeeDTO getEmployeeByPasswordAndEmpNumber(int empNumber, String password) {
			
		TypedQuery<EmployeeEntity> typedQuery = null;
		EmployeeEntity employeeEntity = null;
		EmployeeDTO employeeDTO = new EmployeeDTO();
		  
		typedQuery = 
				entityManager.createQuery("from EmployeeEntity where empNumber=:empNo and password=:pwd  ",EmployeeEntity.class);
		typedQuery.setParameter("empNo", empNumber);
		typedQuery.setParameter("pwd", password);
		
		employeeEntity = typedQuery.getSingleResult();
		
		Common.copyProperties(employeeDTO, employeeEntity);
		
		return employeeDTO;
	}
	
	
//	--------------- getEmployeeBySerialNo ---------------
	@Override
	public EmployeeDTO getEmployeeBySerialNo(int slNo)
	{	
		TypedQuery<EmployeeEntity> typedQuery = null;
		
		EmployeeDTO empDTO = new EmployeeDTO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		EmployeeEntity empEntity = null;
		
		typedQuery = entityManager.createQuery("from EmployeeEntity where serialNumber=:sNo and isDeleted=:val",EmployeeEntity.class);
		typedQuery.setParameter("sNo", slNo);
		typedQuery.setParameter("val", "N");
		
		empEntity = typedQuery.getSingleResult();
		
		//set dept Id
		empDTO.setDept_id(empEntity.getDepartment().getDeptId());
		
		//Copy to deptDTO
		Common.copyProperties(departmentDTO, empEntity.getDepartment());
		
		Common.copyProperties(empDTO, empEntity);
		
		//set deptID
		empDTO.setDeptDTO(departmentDTO);
		
		return empDTO;
	}
	
//	--------------------- Update USER -------------------
	@Override
	public int updateUser(EmployeeDTO employeeDTO)
	{
		int slNo = 0;
	
		DepartmentEntity deptEntity = new DepartmentEntity();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		if(employeeDTO.getSerialNumber() != null || employeeDTO.getSerialNumber()!=0)
		{
			deptEntity.setDeptId(employeeDTO.getDept_id());
			
			Common.copyProperties(employeeEntity, employeeDTO);
			
			employeeEntity.setDepartment(deptEntity);
			
			employeeEntity = entityManager.merge(employeeEntity);
			
			slNo = employeeEntity.getSerialNumber();
			
		}
		
		return slNo;
	}

}
