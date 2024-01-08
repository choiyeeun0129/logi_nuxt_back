package kr.co.seoulit.erp.account.statement.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class IncomeStatementBean extends BaseTO{
    private String accountInnerCode;
    private String accountName;
    private String parentAccountCode;
    private String income;
    private String incomeSummary;
    private String earlyIncome;
    private String earlyIncomeSummary;
    private String isThisYear;

}
