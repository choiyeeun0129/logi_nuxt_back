package kr.co.seoulit.erp.logistic.outsourcing.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutsourcTO extends BaseTO{
	
private	String claimDate;
private	String dueDate;
private	String itemCode;
private	String itemName;
private	String mrpGatheringNo;
private	int mrpGatheringSeq;
private	int necessaryAmount;
private	String orderOrProductionStatus;
private	int outsourcAmount;
private	int sumPriceOfOutsourc;
private	String unitOfMrpGathering;
private	int unitPriceOfOutsourc;
private String outsourcNo;
private String forwardStatus;

}
