/**
 * 
 */
package com.integra.demo.service;

import java.util.List;

import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;

/**
 * @author Keerteewerulkar
 *
 */
public interface EmployeeService {
	
	
	public List<DepartmentDTO> getDepartmentDetails();
	
	public BaseResponseDTO addEmployee(EmployeeDTO employeeDTO);
	
	public List<EmployeeDTO> getEmployeeDetails();
	
	public BaseResponseDTO updateEmployee(EmployeeDTO employeeDTO);
	
	public BaseResponseDTO deleteEmployee(int empNumber);
	
	public BaseResponseDTO assignProject(int slNo, int pId);
	
	public List<EmployeeDTO> getEmProjectDetails();
}
