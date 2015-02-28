package sms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sms.form.LoginForm;
import sms.form.VisitorFormBean;
import sms.hibernateBean.VisitorDetailBean;
import sms.services.VisitorService;



	@Controller
	@RequestMapping("/guardController")
	public class GuardController {

	@Autowired
	VisitorService visitorService;
		
	@RequestMapping("/guardHome.htm")
	public ModelAndView loginProcess(@ModelAttribute("visitorForm") VisitorFormBean visitorFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("visitorEntryForm");
		return mv;
	}

	@RequestMapping("/addVisitor.htm")
	public ModelAndView addVisitor(@ModelAttribute("visitorForm") VisitorFormBean visitorFormBean){
		
		if(visitorFormBean!=null){
	        VisitorDetailBean objVisitorBean=new VisitorDetailBean();
	        objVisitorBean.setName(visitorFormBean.getName());
	        objVisitorBean.setAddress(visitorFormBean.getAddress());
	        objVisitorBean.setReason(visitorFormBean.getReason());
	        visitorService.saveVisitor(objVisitorBean);
		}
		 ModelAndView mv=new ModelAndView();
		    mv.setViewName("visitorEntryForm");
			return mv;
	}

	
}
