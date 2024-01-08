package kr.co.seoulit.erp.logistic.purchase.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BomInfoTO extends BaseTO {

	private String itemCode;
	private String parentItemCode;
	private int no;
	private String itemName;
	private String itemClassification;
	private String itemClassificationName;
	private int netAmount;
	private String description;

}
