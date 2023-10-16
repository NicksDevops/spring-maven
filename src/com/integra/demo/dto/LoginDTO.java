package com.integra.demo.dto;

public class LoginDTO {
	
	private Integer empNo;
	private String pwd;
	public String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginDTO() {
		
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserDTO [empNo=" + empNo + ", pwd=" + pwd + "]";
	}
	
	
	
}
