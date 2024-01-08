package kr.co.seoulit.erp.hr.salary.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

@CrossOrigin("*")
@RestController
@RequestMapping("/hr/salary/*")
public class BonusController {
	
	@Autowired
	private  SalaryServiceFacade salaryServiceFacade;
	HashMap<String,Object> map = new HashMap<>();
	
	@RequestMapping(value = "/findterBonus",method = RequestMethod.GET)
	public HashMap<String,Object> findterBonus(@RequestParam String empCode,@RequestParam String applyYearMonth){
		try {
			BonusTO bonus = new BonusTO();
			bonus.setEmpCode(empCode);
			bonus.setApplyYearMonth(applyYearMonth);
			map.put("empBonus", salaryServiceFacade.findterBonus(bonus));
			map.put("errorMsg","success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}

		return map;
	}

	@RequestMapping(value = "/registerBonus",method = RequestMethod.POST)
	public HashMap<String,Object> registerBonus(@RequestBody BonusTO bonus){
		try {
			salaryServiceFacade.registerBonus(bonus);
			map.clear();
			map.put("errorMsg","success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
	
	@RequestMapping(value = "/removeAllBonus",method = RequestMethod.POST)
	public HashMap<String,Object> removeAllBonus(){
		try {		
			salaryServiceFacade.removeAllBonus();
			map.clear();
			map.put("errorMsg","success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
}