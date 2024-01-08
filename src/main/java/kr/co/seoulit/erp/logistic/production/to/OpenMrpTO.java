package kr.co.seoulit.erp.logistic.production.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OpenMrpTO extends BaseTO {

	private String mpsNo;
	private String bomNo;
	private String itemClassification;
	private String itemCode;
	private String itemName;
	private String orderDate;
	private String requiredDate;
	private String planAmount;
	private String totalLossRate;
	private String caculatedAmount;
	private int requiredAmount;
	private String unitOfMrp;

}
