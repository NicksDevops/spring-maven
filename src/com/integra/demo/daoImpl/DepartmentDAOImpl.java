package com.integra.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.integra.demo.dao.DepartmentDAO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.model.DepartmentEntity;
import com.integra.demo.model.EmployeeEntity;
import com.integra.demo.model.ProjectEntity;
import com.integra.demo.util.Common;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	@PersistenceContext
	EntityManager entityManager;

//	------------- ADD DEPARTMENT --------------------
	@Override
	public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) 
	{

		DepartmentEntity departmentEntity=new DepartmentEntity();

		Common.copyProperties(departmentEntity,departmentDTO);
		
		departmentEntity.setIsDeleted("N");

		entityManager.persist(departmentEntity);

		departmentDTO.setDeptId(departmentEntity.getDeptId());

		return departmentDTO;
	}
	
	
//	------------UPDATE DEPARTMENT ---------------------
	
	@Override
	public int updateDepartment(DepartmentDTO departmentDTO)
	{
		DepartmentEntity deptEntity = new DepartmentEntity();
		
//		if(departmentDTO.getDeptId() != null ||  departmentDTO.getDeptId()!=0)
//		{
//			deptEntity.setDeptId(departmentDTO.getDeptId());
//		}

		
		//Common.copyProperties(deptEntity, departmentDTO);
		
		deptEntity.setDeptId(departmentDTO.getDeptId());
		deptEntity.setDeptName(departmentDTO.getDeptName());
		deptEntity.setDeptDescription(departmentDTO.getDeptDescription());
		deptEntity.setIsDeleted(departmentDTO.getIsDeleted());
		
		deptEntity = entityManager.merge(deptEntity);
		int id =  deptEntity.getDeptId();
		
		return id;
	}
	
//	----------DELETE DEPARTMENT ------------
	@Override
	public String deleteDepartment(int depId)
	{
		String res = null;
		int updatedRows = 0;
		Query query = null;
		TypedQuery<DepartmentEntity> typedQuery = null;
		DepartmentEntity deptEntity = null;
		
		query = 
			entityManager.createQuery(" update DepartmentEntity set isDeleted=:value where deptId =:deptId");
		
		query.setParameter("value", "Y");
		query.setParameter("deptId",depId );
		
		updatedRows = query.executeUpdate();
		
		if(updatedRows > 0)
		{
			typedQuery = 
					entityManager.createQuery("from DepartmentEntity where deptId=:dId ",DepartmentEntity.class);
			typedQuery.setParameter("dId", depId);
			deptEntity = typedQuery.getSingleResult();
			
			if(deptEntity != null)
			{
				res = deptEntity.getIsDeleted();
			}
		}
		
		return res;
		
//		DepartmentEntity deptEntity = (DepartmentEntity)  query.getSingleResult();
//		entityManager.remove(deptEntity);
	}
	
//	------------ Get Employee Detail using deptId -------
	
	@Override
	public List<EmployeeDTO> getEmployeeDetail(int deptId)
	{
		EmployeeDTO empDTO = null;
		TypedQuery<EmployeeEntity> typedQuery = null;
		List<EmployeeDTO> empDTOList = new ArrayList<EmployeeDTO>();
		List<EmployeeEntity> empEntityList = null;
		
		typedQuery = entityManager.createQuery("from EmployeeEntity where dept_id=:dId and isDeleted=:val",EmployeeEntity.class);
		typedQuery.setParameter("dId", deptId);
		typedQuery.setParameter("val", "N");
		
		empEntityList = typedQuery.getResultList();
		
		for(EmployeeEntity entity : empEntityList)
		{
			empDTO = new EmployeeDTO();
			
			Common.copyProperties(empDTO, entity);
			
			empDTOList.add(empDTO);
		}
		
		System.out.println("-- list "+empDTOList );
		return empDTOList;
		
	}


}
