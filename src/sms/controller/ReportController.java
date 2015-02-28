package sms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sms.form.ReportDetailFormBean;
import sms.hibernateBean.StaffRegistrationBean;
import sms.hibernateBean.VisitorDetailBean;
import sms.services.ReportService;


@Controller
@RequestMapping("/reportController")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	//reportController/reportPanel.htm
	@RequestMapping(value="reportPanel.htm",method=RequestMethod.GET)
	public ModelAndView reportPanel(){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("reportPanel");
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
