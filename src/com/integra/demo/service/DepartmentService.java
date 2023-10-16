package com.integra.demo.service;

import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.DepartmentDTO;
import com.integra.demo.dto.EmployeeDTO;

public interface DepartmentService {
	
	public BaseResponseDTO addDepartment(DepartmentDTO departmentDTO);
	
	public BaseResponseDTO updateDepartment(DepartmentDTO departmentDTO);
	
	public BaseResponseDTO deleteDepartment(int deptId);
}
