package kr.co.seoulit.erp.account.statement.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class FinancialPositionBean extends BaseTO{
    private int lev;
    private String category;
    private String accountName;
    private String accountCode;
    private int balanceDetail;
    private long balanceSummary;
    private int preBalanceDetail;
    private int preBalanceSummary;
    private int isThisYear;

}
