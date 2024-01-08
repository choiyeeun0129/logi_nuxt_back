package kr.co.seoulit.erp.account.budget.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper = false)
@Data
public class BudgetComparisonStatusBean extends BaseTO {
	private String sortation,
	applicationBudget,
	compilationBudget,
	executionBudget,
	executionPerformance,
	exampleCompare;
}
