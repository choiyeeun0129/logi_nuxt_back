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

import kr.co.seoulit.erp.hr.attendance.servicefacade.ElasticServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.ElasticTO;

@CrossOrigin("*")
@RequestMapping("/hr/attendance/*")
@RestController
public class ElasticController {

	@Autowired
	private ElasticServiceFacade elasticServiceFacade;

	// 2021/09/06 범석 ~~~~~~ 탄력근무제 조회
	@RequestMapping(value = "/elasticRegister", method = RequestMethod.POST)
	public HashMap<String, Object> findElasticList(@RequestParam("empCode") String empCode,
			@RequestParam("applyDay") String applyDay) {
		HashMap<String, Object> model = new HashMap<>();

		System.out.println("!!!!!!!@@@@@@" + empCode);
		System.out.println("!!!!!!!@@@@@@" + applyDay);
		ArrayList<ElasticTO> elasticList = elasticServiceFacade.findElasticList(empCode, applyDay);
		model.put("elasticList", elasticList);

		System.out.println("!!!!!!!@@@@@@!!!!!!!!" + empCode);
		return model;
	}

	// 2021/09/07 범석 ~~~~~~ 탄력근무제 신청
	@RequestMapping(value = "/elasticInsert", method = RequestMethod.POST)
	public void insertElastic(@RequestParam("empCode") String empCode, @RequestParam("applyDay") String applyDay,
			@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) {
		System.out.println("신청이다 신청 신청 조회말고 신청!!!!!!!!!!");
		System.out.println(empCode);
		System.out.println(applyDay);
		System.out.println(startTime);
		System.out.println(endTime);

		elasticServiceFacade.insertElastic(empCode, applyDay, startTime, endTime);

	}

	// 2021/09/09 범석 ~~~~~~ 탄력근무제 삭제
	@RequestMapping(value = "/elasticDelete", method = RequestMethod.POST)
	public void deleteDayAttd(@RequestBody Map<String, ArrayList<ElasticTO>> data) {
		System.out.println("server까지 날라옴");
		System.out.println(data);
		ArrayList<ElasticTO> elasticDelData = data.get("elasticDelData");
		System.out.println("Controller" + elasticDelData);
		elasticServiceFacade.deleteElastic(elasticDelData);

	}
}
