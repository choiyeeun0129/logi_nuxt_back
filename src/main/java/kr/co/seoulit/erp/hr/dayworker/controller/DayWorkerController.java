package kr.co.seoulit.erp.hr.dayworker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.dayworker.servicefacade.DayWorkerServiceFacade;
import kr.co.seoulit.erp.hr.dayworker.to.DayWorkerTO;

@CrossOrigin("*")
@RequestMapping("/hr/dayworker/*")
@RestController
public class DayWorkerController {

	@Autowired
	private DayWorkerServiceFacade dayWorkerServiceFacade;

	// 2021/12/21 예솔 ~~ 일용직 조회
	@RequestMapping(value = "/findDayworker", method = RequestMethod.GET) 
	public HashMap<String, Object> findDayWorkerList(@RequestParam("empCode") String empCode,
			@RequestParam("empName") String empName) {
		HashMap<String, Object> model = new HashMap<>();

		System.out.println("!!!!!!!@@@@@@" + empCode);
		System.out.println("!!!!!!!@@@@@@" + empName);
		ArrayList<DayWorkerTO> dayWorkerList = dayWorkerServiceFacade.findDayWorkerList(empCode, empName);
		model.put("dayWorkerList", dayWorkerList);

		System.out.println("!!!!!!!@@@@@@!!!!!!!!" + empCode);
		System.out.println("!!!!!!!@@@@@@" + empName);
		return model;
	}

	// 2021/12/21 예솔 ~~ 일용직 신청
	@RequestMapping(value = "/dayworkerInsert", method = RequestMethod.POST)
	public void insertDayWorker(DayWorkerTO dayworker) {
		System.out.println("신청이다 신청 신청 조회말고 신청!!!!!!!!!!");
		System.out.println("dayworkerInsert++++"+dayworker);
		dayWorkerServiceFacade.insertDayWorker(dayworker);

	}

	// 2021/12/21 예솔 ~~ 일용직 삭제
	@RequestMapping(value = "/dayworkerDelete", method = RequestMethod.POST)
	public void deleteDayWorker(@RequestBody Map<String, ArrayList<DayWorkerTO>> data) {
		System.out.println("server까지 날라옴");
		System.out.println(data);
		ArrayList<DayWorkerTO> dayWorkerDelData = data.get("dayWorkerDelData");
		System.out.println("Controller" + dayWorkerDelData);
		dayWorkerServiceFacade.deleteDayWorker(dayWorkerDelData);

	}
	
	// 2021/12/21 예솔 ~~ 일용직 수정
	
}
