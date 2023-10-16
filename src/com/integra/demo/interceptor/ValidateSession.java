package com.integra.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integra.demo.dto.BaseResponseDTO;
import com.integra.demo.dto.EmployeeDTO;

public class ValidateSession implements HandlerInterceptor {
	
	private static Logger log = Logger.getLogger(ValidateSession.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	        throws Exception {
		
		
		try {
			
				EmployeeDTO employeeDTO = (EmployeeDTO)request.getSession().getAttribute("empData");
				
				String path = request.getRequestURI().substring(request.getContextPath().length());
				log.info("Path :"+path);
				
				if(employeeDTO == null)
				{
					log.info("Session expired ===>");
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					ObjectMapper objectMapper = new ObjectMapper();
					BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
					baseResponseDTO.setIsSessionExpired((short)1);
					baseResponseDTO.setRespMessage("Session Expired");
					String fromAjax = request.getParameter("fromAjax");
					if(fromAjax == null || !Boolean.parseBoolean(fromAjax.toLowerCase()))
					{
						response.setStatus(302);
					}
					baseResponseDTO.setContextPath(request.getContextPath());
					response.addHeader("location", request.getContextPath());
					response.getWriter().write(objectMapper.writeValueAsString(baseResponseDTO));
					response.getWriter().close();
					log.info("baseResponseDTO : " +baseResponseDTO);
					return false;
				}
		} catch (Exception e) {
				
			log.error(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			ObjectMapper objectMapper = new ObjectMapper();
			BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
			baseResponseDTO.setIsSessionExpired((short)1);
			baseResponseDTO.setRespMessage("Session Expired");
			String fromAjax = request.getParameter("fromAjax");
			if(fromAjax == null || !Boolean.parseBoolean(fromAjax.toLowerCase()))
			{
				response.setStatus(302);
			}
			baseResponseDTO.setContextPath(request.getContextPath());
			response.addHeader("location", request.getContextPath());
			response.getWriter().write(objectMapper.writeValueAsString(baseResponseDTO));
			response.getWriter().close();
			log.info("baseResponseDTO : " +baseResponseDTO);
			return false;
			
		}
		
	    return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//log.info("--->[postHandle Method]");
		
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//log.info("--->s[afterCompletion Method]");
		

		
	}

}
