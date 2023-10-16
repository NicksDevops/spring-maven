/**
 * 
 */
package com.integra.demo.service;

import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.EmployeeDTO;


public interface UserEmployeeService {
	
	public EmployeeDTO getEmployeeByPasswordAndEmpNumber(int empNumber, String password);
	
	public EmployeeDTO getEmployeeBySerialNo(int slNo);
	
	public BaseResponseDTO updateUser(EmployeeDTO employeeDTO);
}
