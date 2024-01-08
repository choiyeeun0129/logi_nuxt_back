package kr.co.seoulit.erp.account.budget.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.account.base.applicationservice.AccountApplicationService;
import kr.co.seoulit.erp.account.base.to.Account;
import kr.co.seoulit.erp.account.budget.dao.BudgetDAO;
import kr.co.seoulit.erp.account.budget.repository.BudgetRepository;
import kr.co.seoulit.erp.account.budget.to.BudgetBean;
import kr.co.seoulit.erp.account.budget.to.BudgetComparisonStatusBean;
import kr.co.seoulit.erp.account.budget.to.BudgetStatusBean;

@Component
public class BudgetApplicationServiceImpl implements BudgetApplicationService {

	@Autowired
	AccountApplicationService accountApplicationService;

	@Autowired
	private BudgetDAO budgetDAO;

	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public ArrayList<BudgetBean> findBudget(BudgetBean bean) {
		// TODO Auto-generated method stub
		return budgetDAO.selectBudget(bean);
	}

	@Override
	public HashMap<String, Object> orgBudget(BudgetBean bean) {
		// TODO Auto-generated method stub
		return budgetDAO.orgBudget(bean);
	}

	@Override
	public HashMap<String, Object> callBudgetStatus(BudgetBean bean) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		HashMap<String, Object> param = new HashMap<>();

		param.put("deptCode", bean.getDeptCode());
		param.put("workplaceCode", bean.getWorkplaceCode());
		param.put("accountPeriodNo", bean.getAccountPeriodNo());

		budgetDAO.callBudgetStatus(param);
		
		resultMap.put("budgetStatusList", param.get("RESULT"));
		resultMap.put("errorCode", param.get("ERROR_CODE"));
		resultMap.put("errorMsg", param.get("ERROR_MSG"));

		return resultMap;
	}

	@Override
	public ArrayList<BudgetBean> findBudgetAppl(BudgetBean bean) {
		// TODO Auto-generated method stub
		return budgetDAO.selectBudgetAppl(bean);
	}

	@Override
	public HashMap<String, Object> findBudgetComparison(BudgetBean budgetData) {
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<Account> accountList = new ArrayList<>();
		String deptCode = budgetData.getDeptCode();
		String workplaceCode = budgetData.getWorkplaceCode();
		String budgetingCode = budgetData.getBudgetingCode();
		ArrayList<BudgetBean> budgetDataResult = budgetRepository
				.findByDeptCodeAndWorkplaceCodeAndBudgetingCode(deptCode, workplaceCode, budgetingCode);
		for (BudgetBean budgetBean : budgetDataResult) {
			String accountInnerCode = budgetBean.getAccountInnerCode();
			Account account = accountApplicationService.selectAccountName(accountInnerCode);
			accountList.add(account);
		}
		map.put("budgetComparisonList", accountList);

		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public HashMap<String, Object> findBudgetComparisonStatus(BudgetBean budgetData) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<BudgetComparisonStatusBean> budgetComparisonStatus = new ArrayList<BudgetComparisonStatusBean>();
		budgetComparisonStatus = budgetDAO.selectBudgetComparisonStatus(budgetData);
		map.put("budgetComparisonStatusList", budgetComparisonStatus);
		return map;
	}

	@Override
	public HashMap<String, Object> findbudgetExcessStatus(BudgetBean budgetData) {
		// TODO Auto-generated method stub
		HashMap<String, Object> resultMap = new HashMap<>();
		HashMap<String, Object> param = new HashMap<>();

		param.put("deptCode", budgetData.getDeptCode());
		param.put("workplaceCode", budgetData.getWorkplaceCode());
		param.put("accountPeriodNo", budgetData.getAccountPeriodNo());

		budgetDAO.callBudgetStatus(param);

		@SuppressWarnings("unchecked")
		ArrayList<BudgetStatusBean> budgetStatusResult = (ArrayList<BudgetStatusBean>) param.get("RESULT");
		ArrayList<BudgetComparisonStatusBean> comparisonResult = new ArrayList<BudgetComparisonStatusBean>();
		for (BudgetStatusBean budgetStatusBean : budgetStatusResult) {
			BudgetBean budgetBean = new BudgetBean();
			budgetBean.setAccountInnerCode(budgetStatusBean.getAccountInnerCode());
			budgetBean.setAccountPeriodNo(budgetData.getAccountPeriodNo());
			comparisonResult = budgetDAO.selectBudgetComparisonStatus(budgetBean);
		}
		ArrayList<Object> list = new ArrayList<Object>();

		for (int i = 0; i < budgetStatusResult.size(); i++) {
			HashMap<String, Object> resultData = new HashMap<>();
			resultData.put("accountInnerCode", budgetStatusResult.get(i).getAccountInnerCode());
			resultData.put("accountName", budgetStatusResult.get(i).getAccountName());
			resultData.put("budgetExecRatio", budgetStatusResult.get(i).getBudgetExecRatio());
			resultData.put("applicationBudget", comparisonResult.get(i).getApplicationBudget());
			resultData.put("compilationBudget", comparisonResult.get(i).getCompilationBudget());
			resultData.put("executionBudget", comparisonResult.get(i).getExecutionBudget());
			resultData.put("executionPerformance", comparisonResult.get(i).getExecutionPerformance());
			resultData.put("exampleCompare", comparisonResult.get(i).getExampleCompare());
			list.add(resultData);
		}
		resultMap.put("budgetExcessStatusList", list);
		resultMap.put("errorCode", param.get("ERROR_CODE"));
		resultMap.put("errorMsg", param.get("ERROR_MSG"));

		return resultMap;
	}

}
