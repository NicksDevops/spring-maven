/**
 * 
 */
package com.integra.demo.dao;

import com.integra.demo.dto.EmployeeDTO;

public interface UserEmpDAO {
	
	public EmployeeDTO getEmployeeByPasswordAndEmpNumber(int empNumber, String password);
	
	public EmployeeDTO getEmployeeBySerialNo(int slNo);
	
	public int updateUser(EmployeeDTO employeeDTO);
	
	
}
