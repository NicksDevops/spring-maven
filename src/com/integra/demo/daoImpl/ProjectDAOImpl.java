package com.integra.demo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.integra.demo.dao.ProjectDAO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.model.ProjectEntity;
import com.integra.demo.util.Common;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@PersistenceContext
	private EntityManager entityManager;

	//	-------- ADD PROJECT -----------
	@Override
	public ProjectDTO addProject(ProjectDTO projectDTO) {


		ProjectEntity projectEntity = new ProjectEntity();

		Common.copyProperties(projectEntity, projectDTO);
		
		projectEntity.setIsDeleted("N");

		entityManager.persist(projectEntity);

		projectDTO.setProjectId(projectEntity.getProjectId());

		return projectDTO;
	}

	//	------------GET PROJECT DETAILS -----------------
	@Override
	public List<ProjectDTO> getProjectDetails()
	{
		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();
		ProjectDTO projectDTO = null;

		TypedQuery<ProjectEntity> query = 
				entityManager.createQuery("from ProjectEntity where isDeleted=:value", ProjectEntity.class);
		
		query.setParameter("value", "N");

		List<ProjectEntity> entityList = query.getResultList();

		for(ProjectEntity entity: entityList)
		{
			projectDTO = new ProjectDTO();

			Common.copyProperties(projectDTO, entity);

			projectDTOList.add(projectDTO);

		}

		return projectDTOList;
	}

	//	-----------UPDATE PROJECT ---------
	@Override
	public int updateProject(ProjectDTO projectDTO)
	{
		int id = 0;
		
		ProjectEntity projectEntity = new ProjectEntity();
		
		if(projectDTO.getProjectId() != null ||  projectDTO.getProjectId()!=0)
		{
			projectEntity.setProjectId(projectDTO.getProjectId());
		}
		
		Common.copyProperties(projectEntity, projectDTO);

		projectEntity = entityManager.merge(projectEntity);
		
		id = projectEntity.getProjectId();
		
		return id;
	}

	//	----------- DELETE PROJECT ------------

	public String deleteProject(int projectId)
	{
	
		int rowsUpdated = 0;
		TypedQuery<ProjectEntity> typedQuery = null;
		ProjectEntity entity = null;
		String res = null;
		
		Query query = 
				entityManager.createQuery(" UPDATE ProjectEntity p SET p.isDeleted=:value WHERE  p.projectId =:projectID");
		
		query.setParameter("value", "Y");
		query.setParameter("projectID", projectId);
		
		rowsUpdated = query.executeUpdate();
		 
		 if(rowsUpdated > 0)
		 {
			 typedQuery =
					 entityManager.createQuery("from ProjectEntity where projectId=:pId", ProjectEntity.class);
			 typedQuery.setParameter("pId", projectId);
			 
			 entity = typedQuery.getSingleResult();
			 
			 if(entity != null)
			 {
				 res = entity.getIsDeleted(); 
			 }
			
		 }
		
		 return res;
	}
	
//	-------------- GET PROJECT ---------------
	@Override
	public ProjectEntity getProject(int pID)
	{
		TypedQuery<ProjectEntity> typedQuery = null;
		ProjectEntity projectEntity = new ProjectEntity();
		//ProjectDTO projectDTO  = new ProjectDTO();
		
		typedQuery = entityManager.createQuery("from ProjectEntity where projectId=:id",ProjectEntity.class);
		typedQuery.setParameter("id", pID);
		
		projectEntity = typedQuery.getSingleResult();
		
		//Common.copyProperties(projectDTO, projectEntity);
		
		return projectEntity;
	}
}
