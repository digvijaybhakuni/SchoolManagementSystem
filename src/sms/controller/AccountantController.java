package sms.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sms.form.ExpansesFormBean;
import sms.form.FeeFormBean;
import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StudentFeeBean;
import sms.serviceImpl.ExpansesServiceImpl;
import sms.services.ExpansesService;




@Controller
@RequestMapping("/accountantController")
public class AccountantController {

	ExpansesService objExpService=new ExpansesServiceImpl();
	
	
	@RequestMapping("/openAccountPanel.htm")
	public ModelAndView openAccountPanel(@ModelAttribute("feeFormBean")  FeeFormBean feeFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("accountPanel");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	
	@RequestMapping("/feeSubmissionForm.htm")
	public ModelAndView feeSubmissionForm(@ModelAttribute("feeFormBean")  FeeFormBean feeFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("feeSubmissionForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	
	@RequestMapping("/salaryForm.htm")
	public ModelAndView salaryForm(@ModelAttribute("feeFormBean")  FeeFormBean feeFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("salaryPaymentForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	
	@RequestMapping("/reportForm.htm")
	public ModelAndView reportForm(@ModelAttribute("feeFormBean")  FeeFormBean feeFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("reportForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	@RequestMapping("/expenseForm.htm")
	public ModelAndView expenseForm(@ModelAttribute("feeFormBean")  FeeFormBean feeFormBean){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("expenseForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	
	@RequestMapping(value="/saveExpanses.htm", method=RequestMethod.POST)
	public void saveExpanses(@ModelAttribute("ExpansesFormBean")ExpansesFormBean objExpBean){
		ExpansesHibernateBean objExpHiberBean=new ExpansesHibernateBean();
		objExpHiberBean.setExpanse(objExpBean.getExpanse());
		objExpHiberBean.setId(objExpBean.getId());
		objExpHiberBean.setName(objExpBean.getName());
		objExpHiberBean.setAddedDate(new Date().toString());
		objExpService.saveExpanses(objExpHiberBean);
	   
	}
	
	@RequestMapping(value="/feeSubmit.htm", method=RequestMethod.POST)
	public ModelAndView feeSubmission(@ModelAttribute("feeFormBeam")FeeFormBean feeFormBean){
		StudentFeeBean feeBean=new StudentFeeBean();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		feeBean.setBranchCode("s002");
		feeBean.setRegNo(Long.parseLong(feeFormBean.getRegNo()));
		feeBean.setFeeDaposited(feeFormBean.getFeeDaposited());
		feeBean.setFine(feeFormBean.getFine());
		feeBean.setRollno(Long.parseLong(feeFormBean.getRegNo()));
		feeBean.setStudentClass(feeFormBean.getStudentClass());
		feeBean.setDepDate(date.toString());
		objExpService.feeSubmit(feeBean);
		ModelAndView mv=new ModelAndView();
	    mv.setViewName("accountPanel");
		return mv;
	}
	
}
