 /**
 * 
 */
package com.integra.demo.daoImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;

import com.integra.demo.dao.EmployeeDAO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.model.DepartmentEntity;
import com.integra.demo.model.EmployeeEntity;
import com.integra.demo.model.ProjectEntity;
import com.integra.demo.util.Common;


 @Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceContext
	EntityManager entityManager;
	
//	----------Add Employee ---------------
	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) 
	{
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		DepartmentEntity deptEntity = null;
		
		Common.copyProperties(employeeEntity, employeeDTO);
		
		if(employeeDTO.getDept_id()!=0)
		{
			deptEntity = new DepartmentEntity();
			
			deptEntity.setDeptId(employeeDTO.getDept_id());
			
			employeeEntity.setDepartment(deptEntity);
			
		}
		
		employeeEntity.setIsDeleted("N");
		
		entityManager.persist(employeeEntity);
		
		employeeDTO.setEmpNumber(employeeEntity.getEmpNumber());
		
		return employeeDTO;
	}

//	-------------Department Details ------------------
	@Override
	public List<DepartmentDTO> getDepartmentDetails()
	{
		DepartmentDTO dpartmentDTO = null;
		List<DepartmentDTO> deptList = new ArrayList<DepartmentDTO>();
		
		//DepartmentEntity departmentEntity = null;
		
		TypedQuery<DepartmentEntity> query = 
				entityManager.createQuery(" from DepartmentEntity where isDeleted=:value",DepartmentEntity.class);
		query.setParameter("value", "N");
		
		List<DepartmentEntity> deptEntityList = query.getResultList();
		
		for(DepartmentEntity entity : deptEntityList)
		{
			dpartmentDTO = new DepartmentDTO();
			
			Common.copyProperties(dpartmentDTO, entity);
			
			deptList.add(dpartmentDTO);
		}
		
		return deptList;
	}
	
//	------------------Get employees ----------------
	
	@Override
	public List<EmployeeDTO> getEmployeeDetails()
	{
		DepartmentDTO deptDTO = null;
		EmployeeDTO employeeDTO = null;
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		
		TypedQuery<EmployeeEntity> query = 
				entityManager.createQuery("from EmployeeEntity where isDeleted=:value", EmployeeEntity.class);
		query.setParameter("value", "N");
		
		List<EmployeeEntity> employeeList = query.getResultList();
		
		//System.out.println(employeeList);
		
		for(EmployeeEntity entity : employeeList)
		{
			deptDTO = new DepartmentDTO();
			employeeDTO = new EmployeeDTO();
			
			Common.copyProperties(employeeDTO, entity);
			
			employeeDTO.setDept_id(entity.getDepartment().getDeptId());
			
			//get departmentENtity copy to DTO 
			Common.copyProperties(deptDTO, entity.getDepartment());
			
			//Set deptDTO to EmployeeDTo
			employeeDTO.setDeptDTO(deptDTO);
			
			empDTOList.add(employeeDTO);
			
		}
		
		return empDTOList;
	}
	
//	------------ UPDATE EMPLOYEE --------------
	@Override
	public int updateEmployee(EmployeeDTO employeeDTO)
	{
		int numberOfRows = 0;
		Query query = null;
	
		DepartmentEntity deptEntity = new DepartmentEntity();
//		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		if(employeeDTO.getSerialNumber() != null || employeeDTO.getSerialNumber()!=0)
		{
			deptEntity.setDeptId(employeeDTO.getDept_id());
			
//			Common.copyProperties(employeeEntity, employeeDTO);
//			
//			employeeEntity.setDepartment(deptEntity);
//			
//			employeeEntity = entityManager.merge(employeeEntity);
			
			query = entityManager.createQuery("update EmployeeEntity e set e.firstName=:fName, e.middleName=:mName, "
					+ "e.lastName=:lName, e.gender=:gender, e.edution=:education, e.address=:address,"
					+ " e.married=:married, e.password=:password, e.department=:dept where e.serialNumber=:sNo");
			
			query.setParameter("fName", employeeDTO.getFirstName());
			query.setParameter("mName", employeeDTO.getMiddleName());
			query.setParameter("lName", employeeDTO.getLastName());
			query.setParameter("gender", employeeDTO.getGender());
			query.setParameter("education", employeeDTO.getEdution());
			query.setParameter("address", employeeDTO.getAddress());
			query.setParameter("married", employeeDTO.getMarried());
			query.setParameter("password", employeeDTO.getPassword());
			query.setParameter("dept", deptEntity );
			query.setParameter("sNo", employeeDTO.getSerialNumber());
			
			numberOfRows = query.executeUpdate();
			
			//numberOfRows = employeeEntity.getSerialNumber();	
		}
		
		return numberOfRows;
	}
	
	
//	-------------- DELETE EMPLOYEE ------------------
	
	@Override
	public String deleteEmployee(int empNumber)
	{
		int rowsUpdated = 0;
		TypedQuery<EmployeeEntity> typedQuery = null;
		EmployeeEntity entity = null;
		String res = null;
		
		Query query = entityManager.createQuery(" update EmployeeEntity e set e.isDeleted=:value  where empNumber=:empno");
		
		
		query.setParameter("value", "Y");
		query.setParameter("empno", empNumber);
		
		rowsUpdated = query.executeUpdate();
		
		
		if(rowsUpdated > 0)
		{
			entityManager.clear();
			typedQuery = 
					entityManager.createQuery(" from EmployeeEntity where empNumber=:number", EmployeeEntity.class);
			typedQuery.setParameter("number", empNumber);
			
			entity = typedQuery.getSingleResult();
			if(entity != null)
			{
				res = entity.getIsDeleted();
			}
		}
		
		System.out.println("------->"+res);
		return res;
	}	
	
//	------------GET EMPLOYEE using SERIAL NUMBER  ---------
	@Override
	public EmployeeEntity getEmployee(int id) 
	{
		TypedQuery<EmployeeEntity> typedQuery = null;
		EmployeeEntity empEntity = new EmployeeEntity();
		//EmployeeDTO empDTO = new EmployeeDTO();
		
		typedQuery = entityManager.createQuery("from EmployeeEntity where serialNumber=:sNo",EmployeeEntity.class);
		typedQuery.setParameter("sNo", id);
		
		empEntity = typedQuery.getSingleResult();
		
		//Common.copyProperties(empDTO, empEntity);
		
		return empEntity;
	}
	
//	------------GET EMPLOYEE using EMP NUMBER  ---------
	@Override
	public EmployeeDTO getEmployeeBYEmpNumber(int empNumber) 
	{
		TypedQuery<EmployeeEntity> typedQuery = null;
		EmployeeEntity empEntity = new EmployeeEntity();
		EmployeeDTO empDTO = new EmployeeDTO();
		
		typedQuery = entityManager.createQuery("from EmployeeEntity where empNumber=:empNo",EmployeeEntity.class);
		typedQuery.setParameter("empNo", empNumber);
		
		empEntity = typedQuery.getSingleResult();
		
		Common.copyProperties(empDTO, empEntity);
		
		return empDTO;
	}
	
	
//  --------------Assign Project -------------------
	@Override
	public void assignProject(EmployeeEntity empEntity)
	{
		
		System.out.println("------------"+empEntity);
	
		entityManager.persist(empEntity);
		
		
	}
	
	
//	--------------Get Employees for Assign Table -----------
	
	@Override
	public List<EmployeeDTO> getEmProjectDetails()
	{
		System.out.println("----------INSIDE DAOIMPL --------");
		DepartmentDTO deptDTO = null;
		EmployeeDTO employeeDTO = null;
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		
		
		ProjectDTO projectDTO = null;
		List<ProjectEntity> projectEntityList = null;
		List<ProjectDTO> projectDTOList = null;
		
		TypedQuery<EmployeeEntity> query = 
				entityManager.createQuery("from EmployeeEntity where isDeleted=:value", EmployeeEntity.class);
		query.setParameter("value", "N");
		
		List<EmployeeEntity> employeeList = query.getResultList();
		
		//System.out.println(employeeList);
		
		for(EmployeeEntity entity : employeeList)
		{
			deptDTO = new DepartmentDTO();
			employeeDTO = new EmployeeDTO();
			projectDTOList = new ArrayList<ProjectDTO>();
			
			projectEntityList = entity.getProjectEntityList();
			
			for (ProjectEntity proentity : projectEntityList){
				
				projectDTO = new ProjectDTO();
				Common.copyProperties(projectDTO, proentity);
				projectDTOList.add(projectDTO);
			}
			
			Common.copyProperties(employeeDTO, entity);
			
			employeeDTO.setDept_id(entity.getDepartment().getDeptId());
			
			//get departmentENtity copy to DTO 
			Common.copyProperties(deptDTO, entity.getDepartment());
			
			//Set deptDTO to EmployeeDTo
			employeeDTO.setDeptDTO(deptDTO);
			
			employeeDTO.setProjectDTOList(projectDTOList);
			
			System.out.println("--------->"+entity);
			System.out.println("--------->"+entity.getProjectEntityList());
			
			System.out.println("--\n--\n--\n"+projectDTOList);
			
			empDTOList.add(employeeDTO);
		}
		
		return empDTOList;
	}
	
	
	
}
