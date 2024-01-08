package kr.co.seoulit.erp.account.statement.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class TotalTrialBalanceBean extends BaseTO{

    private int lev;
    private String accountName;
    private String accountInnerCode;
    private int debitsSumBalance;
    private int debitsSum;
    private int creditsSum;
    private int creditsSumBalance;

}
