package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/salary/*")
public class BaseDeductionController {

	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	HashMap<String, Object> map = new HashMap<>();

	@RequestMapping(value = "/baseDeductionManage", method = RequestMethod.GET)
	public HashMap<String, Object> findBaseDeductionList() {
		try {
			ArrayList<BaseDeductionTO> baseDeductionList = salaryServiceFacade.findBaseDeductionList();
			map.put("baseDeductionList", baseDeductionList);
			BaseDeductionTO emptyBean = new BaseDeductionTO();
			emptyBean.setStatus("insert");
			map.put("emptyBean", emptyBean);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}

		return map;
	}

	@RequestMapping(value = "/baseDeductionManage", method = RequestMethod.POST)
	public HashMap<String, Object> batchBaseDeductionProcess(
			@RequestBody Map<String, ArrayList<BaseDeductionTO>> sendData) {
		try {
			ArrayList<BaseDeductionTO> baseDeductionList = sendData.get("sendData");
			salaryServiceFacade.batchBaseDeductionProcess(baseDeductionList);
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
}