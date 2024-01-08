package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.attendance.servicefacade.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.MonthAttdMgtTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/attendance/*")
public class MonthAttdManageController {

	@Autowired
	private AttdServiceFacade attdServiceFacade;

	private ModelMap modelMap = new ModelMap();

	@RequestMapping(value = "/monthAttendanceManage", method = RequestMethod.GET)
	public ModelMap findMonthAttdMgtList(@RequestParam String applyYearMonth) {
		// TODO Auto-generated method stub
		ArrayList<MonthAttdMgtTO> monthAttdMgtList = null;
		try {
			monthAttdMgtList = attdServiceFacade.findMonthAttdMgtList(applyYearMonth);
			modelMap.put("monthAttdMgtList", monthAttdMgtList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);

		} catch (Exception ioe) {

			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}

	@RequestMapping(value = "/monthAttendanceClose", method = RequestMethod.POST) // 월 마감 함수
	public ModelMap modifyMonthAttdList(@RequestBody HashMap<String, ArrayList<MonthAttdMgtTO>> monthAttdMgt) {

		System.out.println("QWEQWEQWEWQEQWEWQEWQ" + monthAttdMgt);

		try {
			ArrayList<MonthAttdMgtTO> monthAttdMgtList = monthAttdMgt.get("monthAttdMgt");
//			Gson gson = new Gson();
//			ArrayList<MonthAttdMgtTO> monthAttdMgtList = gson.fromJson(sendData, new TypeToken<ArrayList<MonthAttdMgtTO>>(){}.getType());
//			attdServiceFacade.modifyMonthAttdMgtList(monthAttdMgtList);
			attdServiceFacade.modifyMonthAttdMgtList(monthAttdMgtList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception ioe) {

			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
		}
		return modelMap;
	}

}
