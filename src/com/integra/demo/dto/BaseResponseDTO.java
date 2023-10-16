package com.integra.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.integra.demo.util.Common;

public class BaseResponseDTO implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -3811079587116255368L;

	public static final String SUCCESS_STATUS = "00";
	public static final String FAILURE_STATUS = "01";
	public static final String WARNING_STATUS = "02";
	public static final int SESSION_EXPIRED = 1;

	public BaseResponseDTO()
	{
	}
	private String respStatus;
	private String respCode;
	private String respDesc;
	//	private NextAction nextAction = null;
	private String ts;
	private String sPKey;
	//	private String nextRotation;
	private String checksum;
	private String chkSum;
	private String path;
	private String ci;
	private String status;
	private String respMessage;
	private Object respBuffer;
	private String updateType;
	
	private short isSessionExpired;
	private String contextPath;
	
	public short getIsSessionExpired() {
		return isSessionExpired;
	}
	public void setIsSessionExpired(short isSessionExpired) {
		this.isSessionExpired = isSessionExpired;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	
	private Map<String, Object> additionalValues;

	public Map<String, Object> getAdditionalValues()
	{
		return this.additionalValues;
	}
	public void setAdditionalValues(Map<String, Object> additionalValues)
	{
		this.additionalValues = additionalValues;
	}
	public String getChkSum()
	{
		return this.chkSum;
	}
	public void setChkSum(String chkSum)
	{
		this.chkSum = chkSum;
	}
	public String getCi()
	{
		return this.ci;
	}
	public void setCi(String ci)
	{
		this.ci = ci;
	}
	public String getRespStatus() {
		return this.respStatus;
	}
	public void setRespStatus(String respStatus) {
		this.respStatus = respStatus;
	}

	public String getStatus()
	{
		return this.status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getRespMessage()
	{
		return this.respMessage;
	}
	public void setRespMessage(String respMessage)
	{
		this.respMessage = respMessage;
	}
	public Object getRespBuffer()
	{
		return this.respBuffer;
	}
	public void setRespBuffer(Object respBuffer)
	{
		this.respBuffer = respBuffer;
	}
	public String getRespCode() {
		return this.respCode;
	}
	public BaseResponseDTO(String respStatus, String respCode, String respDesc)
	{
		super();
		this.respStatus = respStatus;
		this.respCode = respCode;
		this.respDesc = respDesc;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespDesc() {
		return this.respDesc;
	}
	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}



	public String getTs() {
		return this.ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getsPKey() {
		return this.sPKey;
	}
	public void setsPKey(String sPKey) {
		this.sPKey = sPKey;
	}


	public String getChecksum() {
		return this.checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public boolean isSuccessResponse()
	{
		boolean result = false;
		if((this.status != null) && this.status.equals(Common.SUCCESS_STATUS))
		{
			result = true;
		}
		return result;
	}
	@Override
	public String toString() {
		return "BaseResponseDTO [respStatus=" + respStatus + ", respCode=" + respCode + ", respDesc=" + respDesc
				+ ", ts=" + ts + ", sPKey=" + sPKey + ", checksum=" + checksum + ", chkSum=" + chkSum + ", path=" + path
				+ ", ci=" + ci + ", status=" + status + ", respMessage=" + respMessage + ", respBuffer=" + respBuffer
				+ ", updateType=" + updateType + ", isSessionExpired=" + isSessionExpired + ", contextPath="
				+ contextPath + ", additionalValues=" + additionalValues + "]";
	}
	





}

