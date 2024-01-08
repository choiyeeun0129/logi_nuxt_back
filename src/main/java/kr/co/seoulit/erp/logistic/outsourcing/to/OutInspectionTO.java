package kr.co.seoulit.erp.logistic.outsourcing.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OutInspectionTO {
	private String claimDate;
	private String dueDate;
	private String itemCode;
	private String itemName;
	private String mrpGatheringNo;
	private String mrpGatheringSeq;
	private String necessaryAmount;
	private String orderOrProductionStatus;
	private String outSourcAmount;
	private String sumPriceOfOutsourc;
	private String unitOfMrpGathering;
	private String unitPriceOfOutsourc;
	private String outsourcNo;
	private String forwardStatus;
	private String completionStatus;
	private String actualCompletionAmount;
	
	
}
