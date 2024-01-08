package kr.co.seoulit.erp.hr.salary.to;

import lombok.Data;

@Data
public class MonthDeductionTO {
	private String empCode, applyYearMonth, deductionCode, deductionName, price;
}
