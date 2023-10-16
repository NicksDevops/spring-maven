package com.integra.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.integra.demo.dto.EmployeeDTO;
import com.integra.demo.dto.LoginDTO;
import com.integra.demo.service.UserEmployeeService;
import com.integra.demo.util.Common;
import com.integra.demo.util.PathConstants;
import com.integra.demo.util.ViewConstants;


@Controller
public class HomeController
{
	private static Logger log = Logger.getLogger(HomeController.class);
	
	@Autowired
	private UserEmployeeService userEmployeeService;
	
	@RequestMapping(value = PathConstants.HOME, method= RequestMethod.POST)
	public ModelAndView showView(HttpServletRequest request,  @ModelAttribute("login")LoginDTO loginDTO, Model model)
	{
		log.info("[HomeController] [home]");
		ModelAndView mav =  new ModelAndView();
		//log.info("LogIn details-"+loginDTO);
		
		EmployeeDTO employeeDTO = null;
		
			try
			{
				employeeDTO = 
					userEmployeeService.getEmployeeByPasswordAndEmpNumber(loginDTO.getEmpNo(), loginDTO.getPwd());
				
				if (employeeDTO.getIsAdmin().equals("Y")) 
				{
					model.addAttribute("empData", employeeDTO);
					mav.setViewName(ViewConstants.HOME);
					
				} 
				else 
				{
					model.addAttribute("empData", employeeDTO);
					mav.setViewName(ViewConstants.USER_HOME);

				}
			 
				Common.updateSession(request, employeeDTO);
			 
			}
			catch(Exception e)
			{
				model.addAttribute("errorMessage","Invalid Credentials - UserId/Password is Incorrect");
				mav.setViewName(ViewConstants.USER_LOGIN_PAGE);
			
			}
			
			return mav;
			
//			mav.setViewName(ViewConstants.HOME);
//			mav.setViewName(ViewConstants.USER_HOME);
//			return mav;
		}

	
}
