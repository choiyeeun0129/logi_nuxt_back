package kr.co.seoulit.erp.logistic.production.to;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductionResultManagementTO extends BaseTO {
	
	private String productionResultNo;
	private String workInstructionNo;
	private String description;
	private String productionDate;
	private String itemCode;
	private String unitOfProductionResult;
	private String productionAmount;
	private String itemName;

}