package kr.co.seoulit.erp.account.statement.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class MonthIncomeStatementBean extends BaseTO{
    private String year;
    private String month;
    private String salesSummary;
    private String salesCostSummary;
    private String grossMargin;
    private String salesManageCostSummary;
    private String operatingProfit;
    private String nonOperatingProfitSummary;
    private String nonOperatingCostSummary;
    private String ordinaryProfit;
    private String corporateTaxSummary;
    private String netIncome;

}
