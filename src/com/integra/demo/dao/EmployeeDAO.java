/**
 * 
 */
package com.integra.demo.dao;

import java.util.List;

import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.dto.ProjectDTO;
import com.integra.demo.model.EmployeeEntity;

/**
 * @author Keerteewerulkar
 *
 */

public interface EmployeeDAO {
	
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
	
	public List<DepartmentDTO> getDepartmentDetails();
	
	public List<EmployeeDTO> getEmployeeDetails();
	
	public int updateEmployee(EmployeeDTO employeeDTO);
	
	public String deleteEmployee(int empNumber);
	
	public EmployeeEntity getEmployee(int id);
	
	public EmployeeDTO getEmployeeBYEmpNumber(int empNumber);
	
	public void assignProject(EmployeeEntity empEntity);
	
	public List<EmployeeDTO> getEmProjectDetails();
}
