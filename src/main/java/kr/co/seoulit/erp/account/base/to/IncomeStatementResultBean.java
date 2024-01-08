package kr.co.seoulit.erp.account.base.to;
import lombok.EqualsAndHashCode;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
@EqualsAndHashCode(callSuper=false)
@Data
public class IncomeStatementResultBean extends BaseTO{
    protected int errorCode;
    protected String errorMsg;

}
