package kr.co.seoulit.erp.account.statement.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper=false)
@Data
public class CashFlowStatementBean extends BaseTO{
	private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String cashFlow;
    private String cashFlowSummary;
    private String earlyCashFlow;
    private String earlyCashFlowSummary;
    private String isThisYear;

}
