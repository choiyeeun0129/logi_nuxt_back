package kr.co.seoulit.erp.hr.attendance.controller;

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

import kr.co.seoulit.erp.hr.attendance.servicefacade.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;

@CrossOrigin("*")
@RestController
//@RequestMapping(value = "/hr/*", produces = "application/json")
@RequestMapping("/hr/attendance/*")
public class DayAttdController {
	
	@Autowired
	private AttdServiceFacade attdServiceFacade;

	@RequestMapping(value = "/dayAttendance", method = RequestMethod.GET)
	public HashMap<String, Object> findDayAttdList(@RequestParam("applyDay") String applyDay,
			@RequestParam("empCode") String empCode) {
		HashMap<String, Object> model = new HashMap<>();

		System.out.println(empCode);

		model.put("DayAttdTO", attdServiceFacade.findDayAttdList(empCode, applyDay));
		return model;
	}

	// @RequestMapping(value="insa/attendance/dayAttendance",
	// method=RequestMethod.POST)
	@RequestMapping(value = "/dayAttendance", method = RequestMethod.POST)
	public Map<String, Object> registDayAttd(@RequestBody Map<String, String> dayAttdData) {
		// ("sendData") String sendData
		System.out.println("나와   " + dayAttdData);
		DayAttdTO dayAttd = new DayAttdTO();

		dayAttd.setEmpCode(dayAttdData.get("empCode"));
		dayAttd.setApplyDay(dayAttdData.get("applyDay"));
		dayAttd.setAttdTypeCode(dayAttdData.get("attdType"));
		dayAttd.setAttdTypeName(dayAttdData.get("attdTypeName"));
		dayAttd.setTime(dayAttdData.get("time"));

		HashMap<String, Object> map = attdServiceFacade.registDayAttd(dayAttd);
		System.out.println(map);
		return map;

	}

	@RequestMapping(value = "/deleteDayAttendance", method = RequestMethod.POST)
	public void deleteDayAttd(@RequestBody Map<String, ArrayList<DayAttdTO>> data) {

		ArrayList<DayAttdTO> dayAttdData = data.get("dayAttdData");
		System.out.println(dayAttdData);
		attdServiceFacade.deleteDayAttd(dayAttdData);

	}
}
