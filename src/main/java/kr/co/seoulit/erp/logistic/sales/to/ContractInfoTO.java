package kr.co.seoulit.erp.logistic.sales.to;

import java.util.List;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContractInfoTO extends BaseTO {

	private String contractNo;
	private String estimateNo;
	private String contractType;
	private String contractTypeName;
	private String customerCode;
	private String customerName;
	private String estimateDate;
	private String contractDate;
	private String contractRequester;
	private String personCodeInCharge;
	private String empNameInCharge;
	private String description;
	private List<ContractDetailTO> contractDetailTOList;
	private String deliveryCompletionStatus;

}
