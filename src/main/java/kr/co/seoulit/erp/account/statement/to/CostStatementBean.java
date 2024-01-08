package kr.co.seoulit.erp.account.statement.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;

@EqualsAndHashCode(callSuper=false)
@Data
public class CostStatementBean extends BaseTO{
	private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String cost;
    private String costSummary;
    private String earlyCost;
    private String earlyCostSummary;
    private String isThisYear;

}
