package sms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import sms.form.AdmissionForm;
import sms.form.MstSubjectForm;
import sms.form.ReportDetailFormBean;
import sms.form.ResultUploadFormBean;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.StudentAdmission;
import sms.hibernateBean.VisitorDetailBean;
import sms.services.FrontOfficeService;
import sms.services.ReportService;



@SessionAttributes({"userId"})
@Controller
@RequestMapping("/frontOfficeController")
public class FrontOfficeController {

	@Autowired
	FrontOfficeService frontOfficeService;
	
	@Autowired
	ReportService reportService;
	
	@RequestMapping(value="/openFrontOfficePanel.htm", method=RequestMethod.GET)
	public ModelAndView openFrontOfficePanel(HttpSession session){
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("userId")==null || session.getAttribute("userId").equals("")){
			mv.setViewName("login");
			mv.addObject("message","session Invalid.");
		}else{
			mv.setViewName("openFrontOfficePanel");	
		}
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());frontOfficeController/openFrontOfficePanel.htm
		return mv;
	}
	
	
	@RequestMapping(value="/openAdmissionForm.htm", method=RequestMethod.GET)
	public ModelAndView openAdmissionForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("admissionForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	@RequestMapping(value="/report.htm", method=RequestMethod.GET)
	public ModelAndView reportForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("reportForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	

	@RequestMapping(value="/openResultUploadForm.htm", method=RequestMethod.GET)
	public ModelAndView openResultUploadForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("resultForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	@RequestMapping(value="/resultUploadTable.htm", method=RequestMethod.GET)
	public ModelAndView openResultUploadForm(@RequestParam("className")String className){
		
		List<MstSubjectForm> lstSubForm= frontOfficeService.getSubjectList(className);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("resultUploadTableForm");
	    mv.addObject("lstSubjectForm", lstSubForm);
		return mv;
	}

	
	@RequestMapping(value="/saveResult.htm", method=RequestMethod.POST)
	public ModelAndView saveResult(@ModelAttribute("resultFormBean")ResultUploadFormBean resultForm){
		
		frontOfficeService.saveResult(resultForm);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("resultForm");
		return mv;
	}
	
	@RequestMapping(value="/teacherAttendanceForm.htm", method=RequestMethod.GET)
	public ModelAndView teacherAttendanceForm(){
		
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("teacherAttendanceForm");
	  //  mv.addObject("userId", studentAttendanceFormBean.getClassName());
		return mv;
	}
	
	@RequestMapping(value="/saveStudent.htm", method=RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("studentRegFormBean")AdmissionForm admissionForm){
		
		StudentAdmission studentAdmission=new StudentAdmission();
		studentAdmission.setfName(admissionForm.getfName());
		studentAdmission.setLame(admissionForm.getlName());
		studentAdmission.setmName(admissionForm.getmName());
		studentAdmission.setAddress(admissionForm.getAddress());
		studentAdmission.setCity(admissionForm.getCity());
		studentAdmission.setState(admissionForm.getState());
		studentAdmission.setPin(admissionForm.getPin());
		studentAdmission.setEmail(admissionForm.getEmail());
		studentAdmission.setMobile(admissionForm.getMobile());
		studentAdmission.setDob(admissionForm.getDob());
		studentAdmission.setBloodGroup(admissionForm.getBloodGroup());
		studentAdmission.setSex(admissionForm.getSex());
		studentAdmission.setStudentClass(admissionForm.getStudentClass());
		
		frontOfficeService.saveStudent(studentAdmission);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("openFrontOfficePanel");
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
