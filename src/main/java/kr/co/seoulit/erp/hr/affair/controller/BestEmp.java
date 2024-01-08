package kr.co.seoulit.erp.hr.affair.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.BestEmpTO;

//************ 범석 BEST 사원 뽑기 2021/09/27  시작************
@CrossOrigin("*")
@RequestMapping("/hr/affair/*")
@RestController
public class BestEmp {

	@Autowired
	private EmpServiceFacade empServiceFacade;

	@RequestMapping(value = "/bestEmp", method = RequestMethod.GET)
	public HashMap<String, Object> bestEmp() {
		System.out.println("BEST 사원 구하러 가보자");

		HashMap<String, Object> model = new HashMap<>();

		ArrayList<BestEmpTO> bestEmp = empServiceFacade.bestEmp();

		model.put("bestEmp", bestEmp);
		return model;
	}
}
//************ 범석 BEST 사원 뽑기 2021/09/28  끝************
