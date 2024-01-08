package kr.co.seoulit.erp.logistic.sales.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class logisticExelTO extends BaseTO {
	private String estimateDate;
	private String estimateNo;
	private String customerCode;
	private String customerName;
	private String businessLicenseNumber;
	private String estimateAmount;
	private String unitPriceOfEstimate;
	private String sumPriceOfEstimate;
	private String itemName;

	private String dueDateOfEstimate;
	private String customerTelNumber;

}
