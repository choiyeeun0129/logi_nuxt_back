package kr.co.seoulit.erp.account.budget.to;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BudgetBeanPK implements Serializable {

	private String deptCode;
	private String workplaceCode;
	private String accountInnerCode;
	private String accountPeriodNo;
	private String budgetingCode;
}
