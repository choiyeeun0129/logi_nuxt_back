package kr.co.seoulit.erp.logistic.sales.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalesPlanTO {
	private int unitPriceOfSales;
	private int salesAmount;
	private String salesPlanNo;
	private String description;
	private String salesPlanDate;
	private int sumPriceOfSales;
	private String itemCode;
	private String dueDateOfSales;
	private String unitOfSales;
	private String mpsApplyStatus;
	private String itemName;
	private String status;

}