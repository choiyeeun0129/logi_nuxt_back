package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;

@CrossOrigin("*")
@RequestMapping("/hr/salary/*")
@RestController
public class BaseSalaryController {
	
	// *****************************************08-28 손유찬 시작********************************************************
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	HashMap<String, Object> map = new HashMap<>();

	@RequestMapping(value = "/baseSalaryManage", method = RequestMethod.GET)
	public HashMap<String, Object> findBaseSalaryList() {

		try {
			ArrayList<BaseSalaryTO> baseSalaryList = salaryServiceFacade.findBaseSalaryList();
			map.clear();
			map.put("baseSalaryList", baseSalaryList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/baseSalaryManage", method = RequestMethod.POST)
	public HashMap<String, Object> modifyBaseSalaryList(@RequestBody Map<String, ArrayList<BaseSalaryTO>> sendData) {
		try {
			System.out.println("BaseSalaryController 시작");
			ArrayList<BaseSalaryTO> baseSalaryList = sendData.get("sendData");
			System.out.println(baseSalaryList);
			salaryServiceFacade.modifyBaseSalaryList(baseSalaryList);
			map.clear();
			map.put("errorMsg", "success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}

//*****************************************08-28 손유찬 종료********************************************************

	@RequestMapping(value = "/BaseSalaryList", method = RequestMethod.GET)
	public HashMap<String, Object> BaseSalaryList(HttpServletRequest request, HttpServletResponse response) {
		String selectDeptTitle = request.getParameter("selectDeptTitle");
		try {
			ArrayList<BaseSalaryTO> baseSalaryList = salaryServiceFacade.BaseSalaryList(selectDeptTitle);
			map.clear();
			map.put("gridRowJson", baseSalaryList);
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