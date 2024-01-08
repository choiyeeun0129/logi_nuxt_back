package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.attendance.servicefacade.CorporateEduServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.CorporateEduTO;;


@CrossOrigin("*")
@RequestMapping("/hr/attendance/*")
@RestController
public class CorporateEduController {
	
	@Autowired
	private CorporateEduServiceFacade corporateEduServiceFacade;
	private ModelMap modelMap = new ModelMap();
	
	@RequestMapping("/getClassList")
	public ModelMap getClassList() {
		
		try {
			List<CorporateEduTO> classList = corporateEduServiceFacade.getClassList();
			modelMap.put("gridRowJson", classList);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "success");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
	
	@RequestMapping("/getClass")
	public ModelMap getClass(@RequestParam String classCode) {
		
		try {
			CorporateEduTO to = corporateEduServiceFacade.getClass(classCode); 
			modelMap.put("gridRowJson", to);
			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "success");

		} catch(Exception e) {
			e.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e.getMessage());
		}
		
		return modelMap;
	}
	
	@RequestMapping("/removeClass")
	public void removeClass(String classCode) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			corporateEduServiceFacade.removeClass(classCode);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", "fail");
		}
	}

	@RequestMapping(value="/addClass", method = RequestMethod.POST)
	public void addClass(CorporateEduTO classData) {
		System.out.println("컨트롤러시작");
		System.out.println(classData);
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			corporateEduServiceFacade.addClass(classData);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", "fail");
		}
		System.out.println("컨트롤러끝");
	}
	
	@RequestMapping("/modifyClass")
	public void modifyClass(CorporateEduTO classData) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			corporateEduServiceFacade.modifyClass(classData);
			
		} catch(Exception e) {
			e.printStackTrace();
			map.put("errorCode", 0);
			map.put("errorMsg", "fail");
		}
	}
	
}
