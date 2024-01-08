package kr.co.seoulit.erp.hr.company.controller;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.servicefacade.CooperatorServiceFacade;

import kr.co.seoulit.erp.hr.company.to.CustomerTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/company/*")
public class CustomerController  {

	
	@Autowired
	private CooperatorServiceFacade cooperatorSF;

	
	private ModelMap modelMap = new ModelMap();


	@RequestMapping(value="/searchCustomer",method=RequestMethod.GET)
	public ModelMap searchCustomerList(@RequestParam String searchCondition,@RequestParam String workplaceCode) {

		ArrayList<CustomerTO> customerList = null;
		
		try {

			customerList = cooperatorSF.getCustomerList(searchCondition, workplaceCode);

			modelMap.put("gridRowJson", customerList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (DataAccessException e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

	@RequestMapping(value="/batchWorkplaceListProcess",method=RequestMethod.POST)
	public ModelMap batchListProcess(@RequestBody HashMap<String,ArrayList<CustomerTO>> batchList) {

		ArrayList<CustomerTO> list = batchList.get("batchList");
		
		try {

			HashMap<String, Object> resultMap = cooperatorSF.batchCustomerListProcess(list);

			modelMap.put("result", resultMap);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (DataAccessException e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}

}
