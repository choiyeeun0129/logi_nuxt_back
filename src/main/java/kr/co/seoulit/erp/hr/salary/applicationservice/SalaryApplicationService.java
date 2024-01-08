package kr.co.seoulit.erp.hr.salary.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;
import kr.co.seoulit.erp.hr.salary.to.BaseExtSalTO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

public interface SalaryApplicationService {
	
	public ArrayList<BaseSalaryTO> findBaseSalaryList();
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList);

	public ArrayList<BaseDeductionTO> findBaseDeductionList();
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList);

	public ArrayList<BaseExtSalTO> findBaseExtSalList();
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList);

	public HashMap<String, Object> findMonthSalary(String applyYearMonth, String empCode);
	public ArrayList<MonthSalaryTO> findYearSalary(String applyYear, String empCode);
	public void modifyMonthSalary(MonthSalaryTO monthSalary);
	public HashMap<String, Object> findCloseSalary(String applyYearMonth, String deptCode);
	public void closeSalary(MonthSalaryTO empCodeList);
	public ArrayList<BaseSalaryTO> BaseSalaryList(String selectDeptTitle);
	public ArrayList<SocialInsureTO> findBaseInsureList(String searchYear);
	public ArrayList<SeveranceTO> findSeverancePayList(String empName);
	
}