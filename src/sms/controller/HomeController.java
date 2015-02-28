package sms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import sms.form.LoginForm;
import sms.form.UserRegistrationFormBean;
import sms.hibernateBean.UserRegistrationBean;
import sms.services.LoginService;



@SessionAttributes({"userId"})
@Controller
@RequestMapping("/homeController")
public class HomeController {

	@Autowired
	LoginService loginService;
	
@RequestMapping(value="/loginProcess.htm",method=RequestMethod.POST)
public ModelAndView loginProcess(@ModelAttribute("loginBean")UserRegistrationFormBean userBean){
	
    System.out.println("UserId : "+userBean.getUserId());
    ModelAndView mv=new ModelAndView();
    UserRegistrationBean userRegBean=new UserRegistrationBean();
    userRegBean.setBranchCode(userBean.getBranchCode());
    userRegBean.setPassword(userBean.getPassword());
    userRegBean.setUserName(userBean.getUserId());
    userRegBean.setSchoolcode(userBean.getSchoolCode());
    if(loginService.validateUser(userRegBean)){
 	   mv.setViewName("home");   
    }else{
       mv.addObject("message", "Invalid login detail.");
 	   mv.setViewName("login");
    }
    mv.addObject("userId", userBean.getUserId());
	return mv;
	}

@RequestMapping(value="/home.htm")
public ModelAndView home(){
   ModelAndView mv=new ModelAndView();
   mv.setViewName("home");
   return mv;
}

@RequestMapping(value="/logout.htm")
public ModelAndView logOut(HttpSession session){
    if(session!=null){
    	session.invalidate();
    	session=null;
    }
	ModelAndView mv=new ModelAndView();
	mv.addObject("logout","logout");
	mv.addObject("message", "You have successfully logged out.");
	mv.setViewName("login");
	return mv;

}

}
