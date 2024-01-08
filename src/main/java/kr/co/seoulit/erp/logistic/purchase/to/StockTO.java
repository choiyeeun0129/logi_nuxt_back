package kr.co.seoulit.erp.logistic.purchase.to;

import lombok.Data;

@Data
public class StockTO {

	private String warehouseCode;
	private String itemCode;
	private String itemName;
	private String unitOfStock;
	private String safetyAllowanceAmount;
	private String stockAmount;
	private String orderAmount;
	private String inputAmount;
	private String deliveryAmount;
	private String totalStockAmount;

}