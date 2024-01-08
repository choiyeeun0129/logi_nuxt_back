package kr.co.seoulit.erp.account.budget.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.account.budget.servicefacade.BudgetServiceFacade;
import kr.co.seoulit.erp.account.budget.to.BudgetBean;

@CrossOrigin("*")
@RestController
@RequestMapping("/acc/*")
public class BudgetController {

	@Autowired
	private BudgetServiceFacade budgetServiceFacade;

	@RequestMapping(value = "/budget/findBudget", method = RequestMethod.POST)
	public ArrayList<BudgetBean> findBudget(@RequestBody BudgetBean budgetData) {

		return budgetServiceFacade.findBudget(budgetData);
	}

	@RequestMapping(value = "/budget/findBudgetAppl", method = RequestMethod.POST)
	public ArrayList<BudgetBean> findBudgetAppl(@RequestBody BudgetBean budgetData) {

		return budgetServiceFacade.findBudget(budgetData); 
	}

	@RequestMapping(value = "/budget/findBudgetComparison", method = RequestMethod.POST)
	public HashMap<String, Object> findBudgetComparison(@RequestBody BudgetBean budgetData) {

		return budgetServiceFacade.findBudgetComparison(budgetData);
	}
	
	
	@RequestMapping(value = "/budget/findBudgetComparisonStatus", method = RequestMethod.POST)
	public HashMap<String, Object> findBudgetComparisonStatus(@RequestBody BudgetBean budgetData) {
		
		return budgetServiceFacade.findBudgetComparisonStatus(budgetData);
	}
	
	@RequestMapping(value = "/budget/findbudgetExcessStatus", method = RequestMethod.POST)
	public HashMap<String, Object> findbudgetExcessStatus(@RequestBody BudgetBean budgetData) {

		return budgetServiceFacade.findbudgetExcessStatus(budgetData);
	}

	@RequestMapping(value = "/budget/orgBudget", method = RequestMethod.POST)
	public HashMap<String, Object> orgBudget(@RequestBody BudgetBean budgetData) {

		HashMap<String, Object> param = new HashMap<>();

		try {
			param = budgetServiceFacade.orgBudget(budgetData);
		} catch (Exception e) {
			param.put("errorCode", -1);
			param.put("errorMsg", e.getMessage());
		}
		return param;
	}

	@RequestMapping(value = "/budget/callBudgetStatus", method = RequestMethod.POST)
	public HashMap<String, Object> callBudgetStatus(@RequestBody BudgetBean budgetData) {

		HashMap<String, Object> param = new HashMap<>();

		try {
			param = budgetServiceFacade.callBudgetStatus(budgetData);
		} catch (Exception e) {
			param.put("errorCode", -1);
			param.put("errorMsg", e.getMessage());
		}
		return param;
	}

}
