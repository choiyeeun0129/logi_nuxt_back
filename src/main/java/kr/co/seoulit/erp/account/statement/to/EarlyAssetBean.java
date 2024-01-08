package kr.co.seoulit.erp.account.statement.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class EarlyAssetBean extends BaseTO{
    private String gropuCode;
    private String accountInnerCode;
    private String accountName;
    private String price;
    private String statementsDivision;
    private String balanceDivision;
    private String leftDebtorPrice;
    private String rightCreditsPrice;

}
