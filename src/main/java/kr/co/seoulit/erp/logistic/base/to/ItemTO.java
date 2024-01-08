package kr.co.seoulit.erp.logistic.base.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemTO extends BaseTO {
	private String itemGroupCode;
	private String leadTime;
	private String unitOfStock;
	private int standardUnitPrice;
	private String description;
	private String itemCode;
	private String itemClassification;
	private String lossRate;
	private String itemName;

}