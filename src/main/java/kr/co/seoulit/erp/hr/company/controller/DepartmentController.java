package kr.co.seoulit.erp.hr.company.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.erp.hr.company.servicefacade.OrganizationServiceFacade;

import kr.co.seoulit.erp.hr.company.to.DepartmentTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/company/*")
public class DepartmentController {

	@Autowired
	private OrganizationServiceFacade orgSF;

	private ModelMap modelMap = new ModelMap();
	@GetMapping("/searchDepartment")
	public ModelMap searchDepartmentList(@RequestParam String searchCondition,@RequestParam String companyCode,@RequestParam String workplaceCode, HttpServletResponse response) {

		System.out.println("서치컨디션"+searchCondition);
		System.out.println("컴퍼니코드"+companyCode);
		System.out.println("워크플레이스코드"+workplaceCode);
		ArrayList<DepartmentTO> departmentList = null;

		try {

			departmentList = orgSF.getDepartmentList(searchCondition, companyCode, workplaceCode);

			modelMap.put("gridRowJson", departmentList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		return modelMap;
	}
	
	@RequestMapping(value="/batchDepartmentListProcess" , method = {RequestMethod.POST})
	public  void batchListProcess(@RequestBody HashMap<String,ArrayList<DepartmentTO>> batchList) {
			
        System.out.println("일괄저장 들어오나?");
        
        ArrayList<DepartmentTO> batlist=batchList.get("batchList");
        
        System.out.println(batlist);
        /*
        for(DepartmentTO To:batlist) {
        	System.out.println(To);
        	
        }
        */
		try {

			HashMap<String, Object> resultMap = orgSF.batchDepartmentListProcess(batlist);

			modelMap.put("result", resultMap);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");

		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());

		}
		
	}
}
