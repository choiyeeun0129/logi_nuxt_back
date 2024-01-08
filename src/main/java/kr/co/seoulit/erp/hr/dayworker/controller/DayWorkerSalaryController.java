package kr.co.seoulit.erp.hr.dayworker.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.dayworker.servicefacade.DayWorkerServiceFacade;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerSalaryTO;


@CrossOrigin("*")
@RequestMapping("/hr/dayworkersalary/*")
@RestController
public class DayWorkerSalaryController {

	@Autowired
	private DayWorkerServiceFacade dayWorkerServiceFacade;

	// 2021/12/24 예솔 ~~ 일용직 급여 조회
	@RequestMapping(value = "/dayworkerSalaryRegister", method = RequestMethod.POST)
	public HashMap<String, Object> findDayWorkerSalaryList(@RequestParam("empCode") String empCode,
			@RequestParam("empName") String empName) {
		HashMap<String, Object> model = new HashMap<>();

		System.out.println("!!!!!!!@@@@@@" + empCode);
		System.out.println("!!!!!!!@@@@@@" + empName);
		ArrayList<DayWorkerSalaryTO> dayWorkerSalary = dayWorkerServiceFacade.findDayWorkerSalaryList(empCode, empName);
		model.put("dayWorkerSalary", dayWorkerSalary);

		System.out.println("!!!!!!!@@@@@@!!!!!!!!" + empCode);
		return model;
	}

	// 2021/12/24 예솔 ~~ 일용직 급여 계산하기 (프로시저)
	@RequestMapping(value = "/dayworkerSalaryInsert", method = RequestMethod.POST)
	public void batchInsertDayWorkerSalary(HashMap<String, Object> map){
		System.out.println("신청이다 신청 신청 조회말고 신청!!!!!!!!!!");
		System.out.println("batchInsertDayWorkerSalary++++"+map);
		dayWorkerServiceFacade.batchInsertDayWorkerSalary(map);

	}
	
	// 2021/12/24 예솔 ~~ 일용직 급여 계산하기 (프로시저)
	@RequestMapping(value = "/dayworkerMonthSalaryInsert", method = RequestMethod.POST)
	public void batchInsertDayWorkerMonthSalary(HashMap<String, Object> map){
		System.out.println("신청이다 신청 신청 조회말고 신청!!!!!!!!!!");
		System.out.println("batchInsertDayWorkerMonthSalary++++"+map);
		dayWorkerServiceFacade.batchInsertMonthWorkerSalary(map);

	}

}
