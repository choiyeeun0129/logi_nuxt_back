package kr.co.seoulit.erp.hr.salary.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.erp.hr.salary.applicationservice.BonusApplicationService;
import kr.co.seoulit.erp.hr.salary.applicationservice.SalaryApplicationService;
import kr.co.seoulit.erp.hr.salary.to.BaseDeductionTO;
import kr.co.seoulit.erp.hr.salary.to.BaseExtSalTO;
import kr.co.seoulit.erp.hr.salary.to.BaseSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;
import kr.co.seoulit.erp.hr.salary.to.MonthSalaryTO;
import kr.co.seoulit.erp.hr.salary.to.SeveranceTO;
import kr.co.seoulit.erp.hr.salary.to.SocialInsureTO;

@Service

public class SalaryServiceFacadeImpl implements SalaryServiceFacade{
	@Autowired
	private SalaryApplicationService salaryApplicationService;
	@Autowired
	private BonusApplicationService bonusApplicationService; 
	
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {		
			ArrayList<BaseSalaryTO> baseSalaryList=salaryApplicationService.findBaseSalaryList();
			return baseSalaryList;	
	}
	
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {
			salaryApplicationService.modifyBaseSalaryList(baseSalaryList);					
	}
	
	@Override
	public ArrayList<BaseDeductionTO> findBaseDeductionList() {
			ArrayList<BaseDeductionTO> baseDeductionList=salaryApplicationService.findBaseDeductionList();
			return baseDeductionList;
	}
	
	@Override
	public void batchBaseDeductionProcess(ArrayList<BaseDeductionTO> baseDeductionList) {
			salaryApplicationService.batchBaseDeductionProcess(baseDeductionList);
	}
	
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {
			ArrayList<BaseExtSalTO> baseExtSalList=salaryApplicationService.findBaseExtSalList();
			return baseExtSalList;
	}	
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {
			salaryApplicationService.modifyBaseExtSalList(baseExtSalList);
	}

	@Override
	public HashMap<String, Object> findMonthSalary(String ApplyYearMonth, String empCode) {
		return salaryApplicationService.findMonthSalary(ApplyYearMonth, empCode);
				
	}

	@Override
	public ArrayList<MonthSalaryTO> findYearSalary(String applyYear, String empCode) {
			ArrayList<MonthSalaryTO> monthSalary=salaryApplicationService.findYearSalary(applyYear, empCode);
			return monthSalary;
	}
	
	@Override
	public void modifyMonthSalary(MonthSalaryTO monthSalary) {
			salaryApplicationService.modifyMonthSalary(monthSalary);
	}

	@Override
	public HashMap<String, Object> CloseSalary(String applyYearMonth, String deptCode) {
		// TODO Auto-generated method stub
		return salaryApplicationService.findCloseSalary(applyYearMonth,deptCode);
	}

	@Override
	public void closeMonthSalary(MonthSalaryTO empCodeList) {  //占쎌뜞疫뀀맩肉� 筌띾뜃而�
		salaryApplicationService.closeSalary(empCodeList);
		
	}

	@Override
	public BonusTO findterBonus(BonusTO bonus) {
		// TODO Auto-generated method stub
		return bonusApplicationService.findterBonus(bonus);
	}

	@Override
	public void registerBonus(BonusTO bonus) {
		// TODO Auto-generated method stub
		bonusApplicationService.registerBonus(bonus);
	}

	@Override
	public void removeAllBonus() {
		// TODO Auto-generated method stub
		bonusApplicationService.removeAllBonus();
	}
	
	@Override
	public ArrayList<BaseSalaryTO> BaseSalaryList(String selectDeptTitle) {
			ArrayList<BaseSalaryTO> baseExtSalList=salaryApplicationService.BaseSalaryList(selectDeptTitle);
			return baseExtSalList;
	}	
	
	@Override
	public ArrayList<SocialInsureTO> findBaseInsureList(String searchYear) {
	
			ArrayList<SocialInsureTO> baseInsureList=salaryApplicationService.findBaseInsureList(searchYear);
			return baseInsureList;
	
	}
	
	@Override
	public ArrayList<SeveranceTO> findSeverancePay(String empName) {		
			ArrayList<SeveranceTO> severancePayList=salaryApplicationService.findSeverancePayList(empName);
			return severancePayList;	
	}
}
