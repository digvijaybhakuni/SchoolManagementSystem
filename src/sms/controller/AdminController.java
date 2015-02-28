package sms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sms.form.ExpansesFormBean;
import sms.form.ReportDetailFormBean;
import sms.form.StaffFormBean;
import sms.form.StudentAttendanceFormBean;
import sms.form.UserRegistrationFormBean;
import sms.hibernateBean.ExpansesHibernateBean;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.UserRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;
import sms.serviceImpl.ExpansesServiceImpl;
import sms.services.AdminService;
import sms.services.ExpansesService;
import sms.services.ReportService;





@Controller
@RequestMapping("/adminController")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping("/openAdminPanel.htm")
	public ModelAndView openAdminPanel(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("managementPanel");
		return mv;
	}
	
	
	@RequestMapping("/userRegistrationForm.htm")
	public ModelAndView userRegistrationForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("userRegistrationForm");
		return mv;
	}
	
	@RequestMapping("/stationaryRecordForm.htm")
	public ModelAndView stationaryRecordForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("stationaryRecordForm");
		return mv;
	}
	
	@RequestMapping("/reportForm.htm")
	public ModelAndView reportForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("reportForm");
		return mv;
	}
	
	@RequestMapping("/staffRegistration.htm")
	public ModelAndView expanseForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("staffRegistration");
		return mv;
	}
	
	@RequestMapping(value="/saveStaff.htm", method=RequestMethod.POST)
	public ModelAndView saveStaff(@ModelAttribute("staffRegFormBean")StaffFormBean staffFormBean){
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		Date dob=null;
		try {
			date = sdf.parse(sdf.format(new Date()));
			dob=sdf.parse(sdf.format(staffFormBean.getDob()));
		} catch (ParseException e) {
			try {
				date = sdf.parse(sdf.format(new Date()));
				dob=sdf.parse(sdf.format(new Date()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
		StaffRegistrationBean staffRegBean=new StaffRegistrationBean();
		staffRegBean.setName(staffFormBean.getfName()+" "+staffFormBean.getmName()+" "+staffFormBean.getlName());
		staffRegBean.setAddress(staffFormBean.getAddress());
		staffRegBean.setCity(staffFormBean.getCity());
		staffRegBean.setDateOfJoining(date);
		staffRegBean.setDob(date);
		staffRegBean.setEmail(staffFormBean.getEmail());
		staffRegBean.setMaritalStatus(staffFormBean.getMaritalStatus());
		staffRegBean.setMobile(staffFormBean.getMobile());
		staffRegBean.setNatureOfJob(staffFormBean.getNatureOfJob());
		staffRegBean.setPhone(staffFormBean.getPhone());
		staffRegBean.setState(staffFormBean.getState());
		staffRegBean.setPin(staffFormBean.getPin());
		staffRegBean.setSex(staffFormBean.getSex().charAt(0));
		staffRegBean.setSpecialization(staffFormBean.getSpecialization());
		
		adminService.saveStaff(staffRegBean);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("staffRegistration");
		return mv;
	}
	
	@RequestMapping(value="/registerUser.htm", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userRegistrationFrom")UserRegistrationFormBean userRegFormBean){
		
		UserRegistrationBean userRegBean =new UserRegistrationBean();
		userRegBean.setBranchCode(userRegFormBean.getBranchCode());
		userRegBean.setDepartment(userRegFormBean.getDepartment());
		userRegBean.setEmail(userRegFormBean.getEmail());
		userRegBean.setPassword(userRegFormBean.getPassword());
		userRegBean.setSchoolcode(userRegFormBean.getSchoolCode());
		userRegBean.setUserName(userRegFormBean.getUserId());
		String role="";
		for(String rl: userRegFormBean.getRole()){
			if(role.isEmpty()){
				role=rl;
			}else{
				role+="#"+rl;
			}	
		}
		userRegBean.setRole(role);
		
		adminService.registerUser(userRegBean);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("managementPanel");
		return mv;
	}

	@RequestMapping("/generateReport.htm")
	public ModelAndView generateReport(@RequestParam("reportType")String reportType){
		
		ModelAndView mv=new ModelAndView();
		List lstReport=new ArrayList();
		if(reportType!=null && reportType.equals("visitor")){
			ReportDetailFormBean reportBean=null;
		    List<VisitorDetailBean> lstvisitorBean=reportService.getVisitorDetail();
		    Iterator<VisitorDetailBean> itr=lstvisitorBean.iterator();
		    while(itr.hasNext()){
		    	VisitorDetailBean visitorBean=itr.next();
		    	reportBean=new ReportDetailFormBean();
		    	reportBean.setCol1data(visitorBean.getName());
		    	reportBean.setCol2data(visitorBean.getAddress());
		    	reportBean.setCol3data(visitorBean.getReason());
		    	lstReport.add(reportBean);
		    }
		    mv.addObject("col1","Name");
		    mv.addObject("col2","address");
		    mv.addObject("col3","Reason");
		    mv.addObject("lstReport",lstReport);
			mv.addObject("reportTitle","Visitor");
			mv.setViewName("reportPrint");
		}else if(reportType!=null && reportType.equals("teacher")){
			
			ReportDetailFormBean reportBean=null;
		    List<StaffRegistrationBean> lstvisitorBean=reportService.getStaffDetail();
		    Iterator<StaffRegistrationBean> itr=lstvisitorBean.iterator();
		    while(itr.hasNext()){
		    	StaffRegistrationBean staffBean=itr.next();
		    	reportBean=new ReportDetailFormBean();
		    	reportBean.setCol1data(staffBean.getName());
		    	reportBean.setCol2data(staffBean.getAddress());
		    	reportBean.setCol3data(staffBean.getPhone());
		    	lstReport.add(reportBean);
		    }
		    mv.addObject("lstReport",lstReport);
			mv.addObject("col1","Name");
			mv.addObject("col2","address");
			mv.addObject("col3","Phone");
			mv.addObject("reportTitle","Teacher");
			mv.setViewName("reportPrint");
		}else if(reportType!=null && reportType.equals("student")){
			
			mv.addObject("lstReport",lstReport);
			mv.addObject("col1","Name");
			mv.addObject("col2","address");
			mv.addObject("col3","phone");
			mv.addObject("reportTitle","Student");
			mv.setViewName("reportPrint");
		}else{
			
			
		}
		
		return mv;
		
	}
}

