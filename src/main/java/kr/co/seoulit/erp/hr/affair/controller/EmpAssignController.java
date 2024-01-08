package kr.co.seoulit.erp.hr.affair.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.AssignEmpTO;


@CrossOrigin("*")
@RestController
@RequestMapping("/hr/affair/*")
public class EmpAssignController {
	
	@Autowired
	private EmpServiceFacade empServiceFacade;

	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();

	@RequestMapping(value = "/waitingAssign", method = RequestMethod.GET)
	@ResponseBody
	public void assignEmployment(@RequestParam String CurrentDept, @RequestParam String MoveDept,
			@RequestParam String EmpCode, @RequestParam String assignDate) {

		try {
			System.out.println("=========================EmpAssignController=======================");
			System.out.println("CurrentDept : " + CurrentDept);
			System.out.println("MoveDept : " + MoveDept);
			System.out.println("EmpCode : " + EmpCode);
			System.out.println("assignDate : " + assignDate);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("CurrentDept", CurrentDept);
			map.put("MoveDept", MoveDept);
			map.put("EmpCode", EmpCode);
			map.put("assignDate", assignDate);

			empServiceFacade.addAssignInfo(map);
			empServiceFacade.updateDeptCode(map);
		} catch (Exception e2) {
			e2.printStackTrace();

		}
	}

	HashMap<String, Object> map = new HashMap<>();

	@RequestMapping(value = "/assignList", method = RequestMethod.GET)
	public HashMap<String, Object> findAssignList(@RequestParam String startDate, @RequestParam String endDate) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		System.out.println("=========================EmpAssignController=======================");
		System.out.println("startDate : " + startDate);
		System.out.println("endDate : " + endDate);

		try {
			ArrayList<AssignEmpTO> assignList = empServiceFacade.findAssignList(startDate, endDate);
			System.out.println("@@@@@@@@@@@@@@@" + assignList);
			map.clear();
			map.put("assignList", assignList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}

}
