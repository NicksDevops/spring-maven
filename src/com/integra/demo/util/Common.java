package com.integra.demo.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.integra.demo.controller.EmployeeController11;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.EmployeeDTO;

public class Common
{
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String SUCCESS_STATUS = "00";
	public static final String FAILURE_STATUS = "01";
	public static final String LOGGED_EMP = "Logged User";
	

	public static final String AUTH_SUCCESS = "00";
	
	private static Logger log = Logger.getLogger(EmployeeController11.class);
	
	public static String resolveView(HttpServletRequest request, ViewResolver viewResolver, String screenName, Map<String, Object> map)
    {
            try
            {
                    MockHttpServletResponse mockResp = new MockHttpServletResponse();
                    View resolvedView = viewResolver.resolveViewName(screenName, LocaleContextHolder.getLocale());
                    resolvedView.render(map, request, mockResp);
                    return mockResp.getContentAsString();
            }
            catch (Exception e)
            {
                    log.error("Error while resolving view :: " + screenName + " :: ", e);
            }
            return null;
    }

	
	
	public static void copyProperties(Object destination, Object source) {
		try {
			BeanUtils.copyProperties(destination, source);
		} 
		catch (IllegalAccessException | InvocationTargetException ex ) {
			//
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
	
	
	public static BaseResponseDTO getSuccessResponse(String code, String message, Object buffer) {
		return getBaseResponseDTO(code, message, buffer, BaseResponseDTO.SUCCESS_STATUS);
	}

	public static BaseResponseDTO getSuccessResponse(String code, Object buffer) {
		return getBaseResponseDTO(code, null, buffer, BaseResponseDTO.SUCCESS_STATUS);
	}

	public static BaseResponseDTO getFailureResponse(String code, Object buffer) {
		return getBaseResponseDTO(code, null, buffer, BaseResponseDTO.FAILURE_STATUS);
	}

	public static BaseResponseDTO getFailureResponse(String code, String msg, Object buffer) {
		return getBaseResponseDTO(code, msg, buffer, BaseResponseDTO.FAILURE_STATUS);
	}

	public static BaseResponseDTO getBaseResponseDTO(String respCode, String respDesc, Object buffer, String STATUS) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setRespCode(respCode);
		baseResponseDTO.setStatus(STATUS);
		baseResponseDTO.setRespBuffer(buffer);
		baseResponseDTO.setRespMessage(respDesc);
		return baseResponseDTO;
	}
	
	
	
	//Session Validation
		public static void updateSession(HttpServletRequest request,EmployeeDTO emp)
		{
			//request.getSession().setAttribute(LOGGED_EMP, emp.getEmpNumber());
			request.getSession().setAttribute("empData", emp);

		}
		
//		public static EmployeeDTO getLoggedUser(HttpServletRequest request)
//		{
//			//Integer empId=(Integer) request.getSession(false).getAttribute(LOGGED_EMP);
//			EmployeeDTO emp=(EmployeeDTO)request.getSession(false).getAttribute("empData");
//			return emp;
//		}
	
	
	
}
