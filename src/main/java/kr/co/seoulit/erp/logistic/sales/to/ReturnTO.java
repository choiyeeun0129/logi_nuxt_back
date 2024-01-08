package kr.co.seoulit.erp.logistic.sales.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ReturnTO extends BaseTO{
    private String returnNo;
    private String deliveryNumber;
    private String itemName;
    private String itemCode;
    private String rcvdDate;
    private String returnReason;
    private int returnQty;
    private String returnProcessor;
    private String returnStat;
    private String returnNote;
}
