package kr.co.seoulit.erp.logistic.purchase.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BomTO extends BaseTO {

	private String itemCode;
	private String parentItemCode;
	private int no;
	private int netAmount;
	private String description;
	private String status;
}
