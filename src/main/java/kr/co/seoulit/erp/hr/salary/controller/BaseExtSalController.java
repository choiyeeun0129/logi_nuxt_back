
package kr.co.seoulit.erp.hr.salary.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BaseExtSalTO;

//**************************2020-08-21 63기 손유찬 수정*********************************
@RestController
@CrossOrigin("*")
@RequestMapping("/hr/salary/*")
public class BaseExtSalController {
	@Autowired
	private SalaryServiceFacade salaryServiceFacade;
	private ModelMap map = null;

	@RequestMapping(value = "/baseExtSalManage", method = RequestMethod.GET)
	public ModelMap findBaseExtSalList() {
		try {
			map = new ModelMap();
			ArrayList<BaseExtSalTO> baseExtSalList = salaryServiceFacade.findBaseExtSalList();
			map.put("baseExtSalList", baseExtSalList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/baseExtSalManage", method = RequestMethod.POST)
	public ModelMap modifyBaseExtSalList(@RequestBody Map<String, ArrayList<BaseExtSalTO>> sendData) {

		try {
			map = new ModelMap();
			ArrayList<BaseExtSalTO> baseExtSalList = sendData.get("baseExtSalList");
			System.out.println("**************수정할놈 " + baseExtSalList);
			salaryServiceFacade.modifyBaseExtSalList(baseExtSalList);
			map.put("errorMsg", "success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
}
//**************************2020-08-21 63기 손유찬 수정*********************************
