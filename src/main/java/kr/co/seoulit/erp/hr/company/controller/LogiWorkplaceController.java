package kr.co.seoulit.erp.hr.company.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.co.seoulit.erp.hr.company.servicefacade.OrganizationServiceFacade;
import kr.co.seoulit.erp.hr.company.to.WorkplaceTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr/company/*")
@CrossOrigin("*")
public class LogiWorkplaceController {

	@Autowired
	private OrganizationServiceFacade orgSF;


	private ModelMap modelMap = new ModelMap();

	@RequestMapping(value="/searchWorkplace",method=RequestMethod.GET)
	public ModelMap searchWorkplaceList(@RequestParam String companyCode) {

		ArrayList<WorkplaceTO> workplaceList = null;
		
		try {

			workplaceList = orgSF.getWorkplaceList(companyCode);

			modelMap.put("gridRowJson", workplaceList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	@RequestMapping(value="/batchFinancialAccountAssociatesListProcess",method=RequestMethod.POST)
	public ModelMap batchListProcess(@RequestBody Map<String,ArrayList<WorkplaceTO>> batchList) {
		try {
			//System.out.println(batchList.get("batchList"));
			ArrayList<WorkplaceTO> list=batchList.get("batchList");
			HashMap<String, Object> resultMap = orgSF.batchWorkplaceListProcess(list);

			modelMap.put("result", resultMap);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}
}
