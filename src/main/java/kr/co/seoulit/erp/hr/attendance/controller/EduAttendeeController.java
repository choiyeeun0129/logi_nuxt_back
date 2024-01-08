package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.attendance.servicefacade.EduAttendeeServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.EduAttendeeTO;

@CrossOrigin("*")
@RequestMapping("/hr/attendance/*")
@RestController
public class EduAttendeeController {
	@Autowired
	private EduAttendeeServiceFacade eduAttendeeServiceFacade;
	private ModelMap modelMap= new ModelMap();
	
	@RequestMapping("/getAttendeeAll")
	public ModelMap getAttendeeAll() {
		try {
			List<EduAttendeeTO> attendeelist=eduAttendeeServiceFacade.getAttendeeAll();
			modelMap.put("gridRowJson",attendeelist);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "success");
			
		} catch(Exception e){
			e.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e.getMessage());
		} 
		return modelMap;
	}
	
	@RequestMapping("/getAttendeeList")
	public ModelMap getAttendeeList(String classCode) {
		try {
			List<EduAttendeeTO> list=eduAttendeeServiceFacade.getAttendeeList(classCode);
			modelMap.put("gridRowJson",list);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "success");
			
		} catch(Exception e){
			e.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e.getMessage());
		} 
		return modelMap;
	}


	@RequestMapping("/getAttendee")
	public ModelMap getAttendee(String empNo) {
		try {
			EduAttendeeTO eduAttendeeTO= eduAttendeeServiceFacade.getAttendee(empNo);
			modelMap.put("gridRowJson",eduAttendeeTO);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "success");
		} catch(Exception e){
			e.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e.getMessage());
		} return modelMap;
	}
	
	@RequestMapping("/removeAttendee")
	public void removeAttendee(String empNo, String classCode) {
		
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(empNo);
		try {
			eduAttendeeServiceFacade.removeAttendee(empNo, classCode);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", e.getMessage());
		}
	}
	
	@RequestMapping(value="/addAttendee", method = RequestMethod.POST)
	public void addAttendee(EduAttendeeTO to) {
		System.out.println("컨트롤러시작");
		System.out.println(to);
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			eduAttendeeServiceFacade.addAttendee(to);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", e.getMessage());
		}
		System.out.println("컨트롤러끝");
	}
	
	@RequestMapping("/modifyAttendee")
	public void modifyAttendee(EduAttendeeTO to) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			eduAttendeeServiceFacade.modifyAttendee(to);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", e.getMessage());
		}
	}
	
	}