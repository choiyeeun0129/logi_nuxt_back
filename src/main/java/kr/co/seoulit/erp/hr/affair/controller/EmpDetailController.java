package kr.co.seoulit.erp.hr.affair.controller;

import kr.co.seoulit.erp.hr.affair.servicefacade.EmpServiceFacade;
import kr.co.seoulit.erp.hr.affair.to.EmpTO;
import kr.co.seoulit.erp.hr.affair.to.EmployeeBasicTO;
import kr.co.seoulit.erp.hr.affair.to.EmployeeDetailTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/affair/*")
public class EmpDetailController {
	
	@Autowired
	private EmpServiceFacade empServiceFacade;

	private ModelAndView modelAndView = null;
	private ModelMap modelMap = new ModelMap();

	@GetMapping("/empDetailInfo")
	public Map<String,Object> findEmpDetail(@RequestParam String empCode){
		ArrayList<EmployeeDetailTO> empDetail= null;
		try{
			empDetail = empServiceFacade.findEmpDetail(empCode);
			modelMap.put("empDetailInfo",empDetail);
			modelMap.put("errorCode",1);
			modelMap.put("errorMsg","success");
		}catch(Exception e){
			modelMap.put("errorCode",-2);
			modelMap.put("errorMsg", e);
		}
		return modelMap;
	}

	@RequestMapping(value = "/empDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findAllEmployeeInfo(@RequestParam String company, @RequestParam String workPlace,
			@RequestParam String position, @RequestParam String empName) {

		ArrayList<EmpTO> empDetailedList = null;

		try {
			System.out.println("=========================EmpDetailController=======================");
			System.out.println("company : " + company);
			System.out.println("workPlace : " + workPlace);
			System.out.println("position : " + position);
			System.out.println("empName : " + empName);

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("company", company);
			map.put("workPlace", workPlace);
			map.put("position", position);
			map.put("empName", empName);

			empDetailedList = empServiceFacade.findAllEmpInfo(map);

			modelMap.put("gridRowJson", empDetailedList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "����");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	@RequestMapping(value = "/empUpdate", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> empInfoUpdate(@RequestParam Map<String, ArrayList<EmpTO>> empArray) {

		try {
			System.out.println("=========================EmpDetailController  empInfoUpdate()=======================");

			empServiceFacade.empInfoUpdate(empArray);

			modelMap.put("errorCode", 0);
			modelMap.put("errorMsg", "����");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -1);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}
	/*
	 * WorkInfoTO workInfoTO = new WorkInfoTO(); CareerInfoTO careerInfoTO = new
	 * CareerInfoTO(); EducationInfoTO educationInfoTO = new EducationInfoTO();
	 * LicenseInfoTO licenseInfoTO = new LicenseInfoTO(); FamilyInfoTO familyInfoTO
	 * = new FamilyInfoTO();
	 * 
	 * map.put("emptyFamilyInfoBean",familyInfoTO ); map.put("emptyCareerInfoBean",
	 * careerInfoTO); map.put("emptyEducationInfoBean", educationInfoTO);
	 * map.put("emptyLicenseInfoBean", licenseInfoTO); map.put("emptyWorkInfoBean",
	 * workInfoTO); map.put("errorMsg","success"); map.put("errorCode", 0);
	 */

//은비 사원상세 기본 조회
	@RequestMapping(value = "/searchEmpBasicInfo", method = RequestMethod.GET)
	public ModelMap searchEmpBasicInfo(@RequestParam String empCode, HttpServletResponse response) {

		ArrayList<EmployeeBasicTO> basicInfoList = null;

		try {

			basicInfoList = empServiceFacade.getEmpBasicInfo(empCode);

			modelMap.put("gridRowJson", basicInfoList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (DataAccessException e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		System.out.println("나옵니다요오오옹 " + modelMap);
		return modelMap;
	}

	public ModelAndView modifyEmployee(HttpServletRequest request, HttpServletResponse response) {
//      String sendData = request.getParameter("sendData");

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");

//         Gson gson = new Gson();
//         EmpTO emp = gson.fromJson(sendData, EmpTO.class);
//         
//         empServiceFacade.modifyEmployee(emp);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception e) {
			modelMap.clear();
			modelMap.put("errorMsg", e.getMessage());
		}

		modelAndView = new ModelAndView("jsonView", modelMap);
		return modelAndView;
	}

	public ModelAndView removeEmployeeList(HttpServletRequest request, HttpServletResponse response) {
//      String sendData = request.getParameter("sendData");

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");

//         Gson gson = new Gson();
//         ArrayList<EmpTO> empList = gson.fromJson(sendData, new TypeToken<ArrayList<EmpTO>>(){}.getType());
//         empServiceFacade.deleteEmpList(empList);
			modelMap.put("errorMsg", "success");
			modelMap.put("errorCode", 0);
		} catch (Exception e) {
			modelMap.clear();
			modelMap.put("errorMsg", e.getMessage());
		}

		modelAndView = new ModelAndView("jsonView", modelMap);
		return modelAndView;
	}
}