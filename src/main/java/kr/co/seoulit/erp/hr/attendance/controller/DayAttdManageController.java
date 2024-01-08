package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.attendance.servicefacade.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdMgtTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/attendance/*")
public class DayAttdManageController {
	
	@Autowired
	private AttdServiceFacade attdServiceFacade;
	private ModelMap modelMap = new ModelMap();

	/// �κ� �̸�+��¥�� �˻�
	@RequestMapping(value = "/dayAttendanceManage", method = RequestMethod.GET)
	public ModelMap findDayAttdMgtList(@RequestParam("applyDay") String applyDay) {
		HashMap<String, Object> map = new HashMap<>();

		System.out.println("�̸�" + applyDay);

		try {
			map.put("applyDay", applyDay);
			HashMap<String, Object> result = attdServiceFacade.findDayAttdMgtList(map);

			@SuppressWarnings("unchecked")
			ArrayList<DayAttdMgtTO> dayAttdMgtList = (ArrayList<DayAttdMgtTO>) result.get("result");
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			modelMap.put("dayAttdMgtList", dayAttdMgtList);
		} catch (Exception ioe) {

			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());

		}
		return modelMap;
	}

	/// �κ� ��¥�� ��ü �˻�
	@RequestMapping(value = "/dayAttendanceManageAll", method = RequestMethod.GET)
	public ModelMap findDayAttdMgtListAll(@Param("startDate") String startDate, @Param("endDate") String endDate) {
		System.out.println("����" + startDate);
		System.out.println("����" + endDate);
		HashMap<String, Object> map = new HashMap<>();

		map.put("startDate", startDate);
		map.put("endDate", endDate);

		try {

			ArrayList<DayAttdMgtTO> dayAttdMgtList = attdServiceFacade.findDayAttdMgtListAll(map);

			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			modelMap.put("dayAttdMgtList", dayAttdMgtList);
		} catch (Exception ioe) {

			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());

		}

		return modelMap;
	}

	/// �κ� ��ü ����
	@RequestMapping(value = "/dayDeadlineRegister", method = RequestMethod.PUT)
	public ModelMap modifyDayAttdList(@RequestBody Map<String, ArrayList<DayAttdMgtTO>> DayAttdMgtToList) {

		System.out.println("����" + DayAttdMgtToList);
		HashMap<String, Object> map = new HashMap<>();

		map.put("DayAttdMgtToList", DayAttdMgtToList);

		try {
			ArrayList<DayAttdMgtTO> dayAttdMgtList = attdServiceFacade.dayDeadlineRegister(map);

			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			modelMap.put("dayAttdMgtList", dayAttdMgtList);
		} catch (Exception ioe) {
			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
			modelMap.put("errorCode", -1);
		}
		return modelMap;
	}

	/// �κ� ��ü �������
	@RequestMapping(value = "/dayDeadlineCancel", method = RequestMethod.PUT)
	public ModelMap dayDeadlineCancel(@RequestBody Map<String, ArrayList<DayAttdMgtTO>> DayAttdMgtToList) {

		System.out.println("����" + DayAttdMgtToList);
		HashMap<String, Object> map = new HashMap<>();

		map.put("DayAttdMgtToList", DayAttdMgtToList);

		try {
			attdServiceFacade.dayDeadlineCancel(map);

			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
			// modelMap.put("dayAttdMgtList",dayAttdMgtList);
		} catch (Exception ioe) {
			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());
			modelMap.put("errorCode", -1);
		}
		return modelMap;
	}

//	@RequestMapping(value="/attendance/dayAttendanceManage", method=RequestMethod.GET)
//	public HashMap<Object,Object> findDayAttdMgtList(@Param("applyDay") String applyDay){
//	HashMap<Object,Object> map=new HashMap<>();
//	ArrayList<DayAttdMgtTO> dayAttdMgtList =attdServiceFacade.findDayAttdMgtList(applyDay);
//	map.put("dayAttdMgtList", dayAttdMgtList);
//	return map; 
//	}
//	

	@RequestMapping(value = "/dayAttendanceManageUpdate", method = RequestMethod.POST)
	public ModelMap modifyDayAttdList(@RequestBody HashMap<String, ArrayList<DayAttdMgtTO>> dayAttdMgt) {

//		String sendData = request.getParameter("sendData");

		try {

			System.out.println(dayAttdMgt.get("monthAttdDay"));

//			Gson gson = new Gson();
//			ArrayList<DayAttdMgtTO> dayAttdMgtList = gson.fromJson(sendData, new TypeToken<ArrayList<DayAttdMgtTO>>(){}.getType());

			ArrayList<DayAttdMgtTO> dayAttdMgtList = dayAttdMgt.get("dayAttdMgt");
			attdServiceFacade.modifyDayAttdMgtList(dayAttdMgtList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);

		} catch (Exception ioe) {
			ioe.printStackTrace();
			modelMap.clear();
			modelMap.put("errorMsg", ioe.getMessage());

		}
		return modelMap;
	}

}
