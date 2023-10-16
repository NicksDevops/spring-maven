package com.integra.demo.dao;

import java.util.List;

import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;

public interface DepartmentDAO {
	
	public DepartmentDTO addDepartment(DepartmentDTO deprtmentDTO);
	
	public int updateDepartment(DepartmentDTO departmentDTO);
	
	public String deleteDepartment(int depId);
	
	public List<EmployeeDTO> getEmployeeDetail(int deptId);
	
	
}
