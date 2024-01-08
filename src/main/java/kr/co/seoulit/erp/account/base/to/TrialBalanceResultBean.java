package kr.co.seoulit.erp.account.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper=false)
@Data
public class TrialBalanceResultBean extends BaseTO{
    protected int errorCode;
    protected String errorMsg;

}
