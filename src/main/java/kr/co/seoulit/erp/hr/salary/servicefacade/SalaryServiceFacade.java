package kr.co.seoulit.erp.hr.salary.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;
import kr.co.seoulit.erp.hr.salary.to.BaseExtSalTO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

public interface SalaryServiceFacade {
	
	public ArrayList<BaseSalaryTO> findBaseSalaryList();
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList);

	public ArrayList<BaseDeductionTO> findBaseDeductionList();
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList);

	public ArrayList<BaseExtSalTO> findBaseExtSalList();
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList);

	public HashMap<String, Object> findMonthSalary(String ApplyYearMonth, String empCode);
	public ArrayList<MonthSalaryTO> findYearSalary(String applyYear, String empCode);
	public void modifyMonthSalary(MonthSalaryTO monthSalary);
	public HashMap<String, Object> CloseSalary(String applyYearMonth, String deptCode);
	public void closeMonthSalary(MonthSalaryTO empCodeList);
	
	public BonusTO findterBonus(BonusTO bonus);
	public void registerBonus(BonusTO bonus);
	public void removeAllBonus();
	public ArrayList<BaseSalaryTO> BaseSalaryList(String selectDeptTitle);
	
	public ArrayList<SocialInsureTO> findBaseInsureList(String searchYear);
	public ArrayList<SeveranceTO> findSeverancePay(String empName);
	
}
