package kr.co.seoulit.erp.account.slip.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
//박미노 추가 2020-11-24
@EqualsAndHashCode(callSuper=false)
@Data
public class JournalDeadlineDivsionBean {
	private String deliveryNo;
	private String estimateNo;
	private String contractNo;
	private String contractDetailNo;
	private String customerCode;
	private String personCodeInCharge;
	private String itemCode;
	private String itemName;
	private String unitOfDelivery;
	private String deliveryAmount;
	private String unitPrice;
	private String sumPrice;
	private String deliverydate;
	private String deliveryPlaceName;
	private String finalizeStatus;
	private String empCode;
	
	private String applyYearMonth;
	private String salary, totalExtSal, totalPayment, totalDeduction, realSalary, cost, unusedDaySalary,
			deptCode;

}
