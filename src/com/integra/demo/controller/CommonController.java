package com.integra.demo.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.integra.demo.util.ViewConstants;
/**
 * @author Keerteewerulkar
 *
 */
@Controller
public class CommonController {
	
	private static Logger log = Logger.getLogger(CommonController.class);
	
	@RequestMapping(value = "/test", method= RequestMethod.GET )
	public  ModelAndView test()
	{
		log.info("Testing ");
		return new ModelAndView(ViewConstants.VIEW_EMPLOYEE);
	}
	
	@RequestMapping(value = "/admin", method= RequestMethod.GET)
	public  ModelAndView adminLteTest()
	{
		log.info("adminLteTest ");
		return new ModelAndView("general");
	}
}
