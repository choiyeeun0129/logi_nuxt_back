package kr.co.seoulit.erp.logistic.sales.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReturnStockTO extends BaseTO{
    private String rtrnRecNo;
    private String returnNo;
    private String rtrnItemCode;
    private String rtrnItemName;
    private int returnQty;
    private String recWrhsCode;
    private String recWrhsName;
    private String recDate;
}
