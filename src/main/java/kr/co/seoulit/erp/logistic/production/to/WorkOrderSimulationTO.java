package kr.co.seoulit.erp.logistic.production.to;

import lombok.Data;

@Data
public class WorkOrderSimulationTO {

	private String mrpNo;
	private String mpsNo;
	private String mrpGatheringNo;
	private String itemClassification;
	private String itemCode;
	private String itemName;
	private String unitOfMrp;
	private String inputAmount;
	private String requiredAmount;
	private String stockAfterWork;
	private String orderDate;
	private String requiredDate;

}
