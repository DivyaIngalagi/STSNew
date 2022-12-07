package com.example.controller;


import java.lang.reflect.Array;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Appointment;
import com.example.model.City;
import com.example.model.Doctor;
import com.example.model.DoctorName;
import com.example.model.Login;
import com.example.model.Patient;
import com.example.service.AappointmentService;
import com.example.service.HospitalService;
import com.example.service.PatientService;




@Controller
public class MainController {

	@Autowired
	HospitalService hopser;

	@Autowired
	PatientService patser;
	
	@Autowired
	AappointmentService appser;
	
	@ModelAttribute("doctors")
	public List<String> preLoad(){
		List<String> doctnamelist = new ArrayList<>();

		List<Doctor> doctorname =hopser.getAllDoctor();
		
		for (Doctor doctor : doctorname) {
			doctnamelist.add(doctor.getFirstName()+" "+doctor.getLastName());
			System.out.println("Hello"+doctor);
		}
		
		
//		City doctname = new City();
//		city.setDname(dname);
//		city.setCityid(1);
//		City city1 = new City();
//		city1.setCity("Pune");
//		city1.setCityid(2);
//		City city2 = new City();
//		city2.setCity("Bangalore");
//		city2.setCityid(3);
//		listCity.add(city);
//		listCity.add(city1);
//		listCity.add(city2);
//		return listCity;
		
		return doctnamelist;
	}


	//model.addAttribute("listCity", listCity);


	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String getPage(Model model)
	{
		Login login = new Login();
		model.addAttribute("admincred", login);
		
		Doctor doctorreg = new  Doctor();
		model.addAttribute("doctorreg", doctorreg);
		
		Doctor showdoctors = new  Doctor();
		model.addAttribute("showdoctor", showdoctors);
			
		Doctor updateDoctor  = new  Doctor();
		model.addAttribute("doctorupd", updateDoctor);
		
		Doctor deleteDoctor  = new  Doctor();
		model.addAttribute("doctordel", deleteDoctor);

		Login patientlogin = new Login();
		model.addAttribute("patientreg", patientlogin);
		
		Patient patientregt = new  Patient();
		model.addAttribute("patientreg", patientregt);
//		
		Appointment patientappbook = new Appointment();
		model.addAttribute("patientbook", patientappbook);
		
		return "main";
		
		
	}
	
	
	
	@RequestMapping(value="/admin",method=RequestMethod.GET)	
	public ModelAndView AdminLoginPage(@ModelAttribute("admincred") Login login)
	{
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminLogin");
		return mv;
		
		
	}
	
	@RequestMapping(value="/adminlogincheck",method=RequestMethod.GET)	
	public ModelAndView AdminLoginCheckPage(@ModelAttribute("admincred") Login login)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("login", login);

		 
		 
		  
		
			  if(login.getLoginUserName().equals("divya") && login.getLoginPassword().equals("1234")) {
				  mv.setViewName("adminPanel");
			  }else {
				  mv.setViewName("invalidcred");
			  }
		  
		  System.out.println(login.getLoginUserName());
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/doctorreg",method=RequestMethod.GET)	
	public ModelAndView DoctorRegPage(@ModelAttribute("doctorreg") Doctor doctorreg)
	{	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("doctorReg");
		return mv;
		
		
	}
	
	@RequestMapping(value="/doctorregs",method=RequestMethod.GET)	
	public ModelAndView DoctorRegisteredMsgPage(@ModelAttribute("doctorreg") Doctor doctorreg)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("doctorreg", doctorreg);
		  
		  Doctor doc = new Doctor();
//		  doc.setDocid(doctorreg.getDocid());
		  doc.setCity(doctorreg.getCity());
		  doc.setAddress(doctorreg.getAddress());
		  doc.setEmail(doctorreg.getEmail());
		  doc.setFirstName(doctorreg.getFirstName());
		  doc.setLastName(doctorreg.getLastName());
		  doc.setGender(doctorreg.getGender());
		  doc.setMobileno(doctorreg.getMobileno());
		  doc.setPassword(doctorreg.getPassword());
		  doc.setQualification(doctorreg.getQualification());
		  doc.setSpecializaton(doctorreg.getSpecializaton());
		  doc.setUsername(doctorreg.getUsername());
		  
		  boolean b = hopser.saveDoctor(doc);
		  
		  if(b == true) {
		  mv.setViewName("success");
		  }else {
		  mv.setViewName("failure");
		  }
		 
		  System.out.println(doctorreg.getFirstName());
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/updatedoctor",method=RequestMethod.GET)	
	public ModelAndView DoctorUpdatePage(@ModelAttribute("doctorupd") Doctor updateDoctor)
	{
		
		
		  ModelAndView mv=new ModelAndView();

		  mv.setViewName("doctorUpdate");

		  
		
		return mv;
		
		
	}
	
	
	@RequestMapping(value="/doctorupdates",method=RequestMethod.GET)	
	public ModelAndView DoctorUpdateMsgPage(@ModelAttribute("doctorupd") Doctor updateDoctor)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  boolean b = hopser.updatebyId(updateDoctor);
		  
		  if(b == true) {
			  mv.setViewName("success");
			  }else {
			  mv.setViewName("failure");
			  }
		  
		
		return mv;
	}
	
	
	@RequestMapping(value="/deletedoctor",method=RequestMethod.GET)	
	public ModelAndView DoctorDeletePage(@ModelAttribute("doctordel") Doctor deleteDoctor)
	{
		
		
		  ModelAndView mv=new ModelAndView();

		  mv.setViewName("deleteDoctor");
		 

		
		return mv;
		
		
	}
	
	
	@RequestMapping(value="/doctordeletes",method=RequestMethod.GET)	
	public ModelAndView DoctorUpdatedMsgPage(@ModelAttribute("doctordel") Doctor deleteDoctor)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  hopser.deletebyId(deleteDoctor.getDocid());
		  mv.setViewName("deletesuccess");
		

		
		return mv;
		
	}
	
	
	
	
	@RequestMapping(value="/viewdoctor",method=RequestMethod.GET)	
	public ModelAndView DoctorViewPage(@ModelAttribute("showdoctor") Doctor showdoctors)
	{
		
		
		  ModelAndView mv=new ModelAndView();

		  mv.setViewName("showDoctor");
		  

		
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/showdoctorbyId",method=RequestMethod.GET)	
	public ModelAndView DoctorDisplayPage(@ModelAttribute("showdoctor") Doctor showdoctors)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		
		  Optional<Doctor> showdoctordetails = hopser.getDoctorById(showdoctors.getDocid());
		  
//		  if(showdoctordetails.isPresent()) {
				Doctor d = showdoctordetails.get();
				
				Doctor doc = new Doctor();
				  doc.setCity(d.getCity());
				  doc.setAddress(d.getAddress());
				  doc.setEmail(d.getEmail());
				  doc.setFirstName(d.getFirstName());
				  doc.setLastName(d.getLastName());
				  doc.setGender(d.getGender());
				  doc.setMobileno(d.getMobileno());
				  doc.setPassword(d.getPassword());
				  doc.setQualification(d.getQualification());
				  doc.setSpecializaton(d.getSpecializaton());
				  doc.setUsername(d.getUsername());
				
		  		mv.addObject("doc",doc);
		  		mv.setViewName("displaydoctor");
//			}
		  
	
	
		return mv;
		
		
	}
	
	@RequestMapping(value="/doctor",method=RequestMethod.GET)	
	public ModelAndView DoctorLoginPage(@ModelAttribute("doctorcred") Login login)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("login", login);
		  mv.setViewName("doctorlogin");
		 
		  System.out.println(login.getLoginUserName());
		
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/doctorlogin",method=RequestMethod.POST)	
	public ModelAndView DoctorPanelPage(@ModelAttribute("doctorcred") Login login)
	{
		
		
		  ModelAndView mv=new ModelAndView();
//		  mv.addObject("login", login);
		  

		  if(login.getLoginUserName().equals("divya") && login.getLoginPassword().equals("1234")) {
			  mv.setViewName("doctorPanel");
		  }else {
			  mv.setViewName("invalidcred");
		  }
		  
	
		  
		  
		
		
		return mv;
		
		
	}
	
	@RequestMapping(value="/patient",method=RequestMethod.GET)	
	public ModelAndView PatientLoginPage(@ModelAttribute("patientcred") Login patientlogin)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("patientlogin",patientlogin);
		  mv.setViewName("patientlogin");
		  return mv;
		
		
	}
	
	@RequestMapping(value="/patientlogin",method=RequestMethod.POST)	
	public ModelAndView PatientLoginSigninPage(@ModelAttribute("patientcred") Login patientlogin,
			@ModelAttribute("patientreg") Patient patientregs)
	{
		System.out.println(patientregs.getUsername());
		System.out.println(patientregs.getPassword());
		
		  ModelAndView mv=new ModelAndView();
		  if(patientlogin.getLoginUserName().equals("divya") && patientlogin.getLoginPassword().equals("1234")) {
			  mv.setViewName("patientPanel");
		  }else {
			  mv.setViewName("patientReg");
		  }
		  
		  return mv;
		
		
	}
	
	@RequestMapping(value="/patientregs",method=RequestMethod.GET)	
	public ModelAndView PatientLoginRegPage(@ModelAttribute("patientreg") Patient patientregt)
	{
		
		
		  ModelAndView mv=new ModelAndView();
		  mv.addObject("patientregt", patientregt);
		  
		  Patient doc = new Patient();

		  doc.setCity(patientregt.getCity());
		  doc.setAddress(patientregt.getAddress());
		  doc.setEmail(patientregt.getEmail());
		  doc.setFirstName(patientregt.getFirstName());
		  doc.setLastName(patientregt.getLastName());
		  doc.setGender(patientregt.getGender());
		  doc.setMobileno(patientregt.getMobileno());
		  doc.setPassword(patientregt.getPassword());
		  doc.setUsername(patientregt.getUsername());
		  
		  boolean b = patser.savePatient(doc);
		  
		  if(b == true) {
		  mv.setViewName("success");
		  }else {
		  mv.setViewName("failure");
		  }
			 
		  
		  
		  return mv;
		
		
	}
	
	
	@RequestMapping(value="/patientbookdetails",method=RequestMethod.POST)	
	public ModelAndView PatientBookPage(@ModelAttribute("patientbook") Appointment patientappbook)
	{
		System.out.println("MainController.PatientBookPage()");
		
		System.out.println(patientappbook);
		
		  ModelAndView mv=new ModelAndView();
//		  mv.addObject("patientappbook", patientappbook);
		  
//		  Appointment app = new Appointment();
		  
//		  app.setAdate(patientappbook.getAdate());
//		  app.setAtime(patientappbook.getAtime());
			 
		  //appser.saveAppointment(patientappbook);
		  
		  
		  mv.setViewName("#");
		  
		  return mv;
		
		
	}
	
	
}






















//ArrayList<String> listCity;
//@ModelAttribute
//public void preLoad(Model model){
//	 listCity = new ArrayList<>();
//	 listCity.add("Super Mario");
//	 listCity.add("Contraaa");
//	 listCity.add("Elevator");
//}


//model.addAttribute("listCity", listCity);