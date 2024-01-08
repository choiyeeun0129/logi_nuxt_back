package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;

@CrossOrigin("*")
@RequestMapping("/hr/salary/*")
@RestController
public class SeverancePayController {

	// *********************2021/09/14 퇴직금조회 고범석*****************//
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;

	@RequestMapping(value = "/severancePay", method = RequestMethod.GET)
	public HashMap<String, Object> findSeveranvePay(@RequestParam("empName") String empName) {
		System.out.println(empName);
		HashMap<String, Object> model = new HashMap<>();
		ArrayList<SeveranceTO> severancePayList = salaryServiceFacade.findSeverancePay(empName);

		model.put("severancePayList", severancePayList);

		return model;
	}
}
