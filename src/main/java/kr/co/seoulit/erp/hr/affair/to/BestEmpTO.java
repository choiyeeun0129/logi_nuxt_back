package kr.co.seoulit.erp.hr.affair.to;

import lombok.Data;

@Data
public class BestEmpTO {
	private String 
		  companyCode 
		, empName 
		, empCode 
		, img 
		, deptCode 
		, deptName
		, weekdayWorkDays 
		, applyYearMonth
		;
}
