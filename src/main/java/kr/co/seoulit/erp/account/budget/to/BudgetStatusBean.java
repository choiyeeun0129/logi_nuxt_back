package kr.co.seoulit.erp.account.budget.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper = false)
@Data
public class BudgetStatusBean extends BaseTO {
	
	private String accountInnerCode;
	private String accountName;
	private int annualBudgetRecord;// 연간 예산 실적
	private int annualBudget;
	private int remainingBudget;
	private double budgetExecRatio;// 집행률
	private int monthBudgetRecord;
	private int monthBudget;
	private int remainingMonthBudget;
	private double monthBudgetExecRatio;// 집행률


}
