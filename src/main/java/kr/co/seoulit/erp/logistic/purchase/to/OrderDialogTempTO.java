package kr.co.seoulit.erp.logistic.purchase.to;

import lombok.Data;

@Data
public class OrderDialogTempTO {
	private String mrpGatheringNo;
	private String itemCode;
	private String itemName;
	private String unitOfMrp;
	private String requiredAmount;
	private String stockAmount;
	private String calculatedRequiredAmount;
	private String standardUnitPrice;
	private String sumPrice;

}
