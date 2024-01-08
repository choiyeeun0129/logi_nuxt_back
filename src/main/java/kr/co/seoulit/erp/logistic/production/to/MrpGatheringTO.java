package kr.co.seoulit.erp.logistic.production.to;

import java.util.ArrayList;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class MrpGatheringTO extends BaseTO {

	private String mrpGatheringNo;
	private String orderOrProductionStatus;
	private String itemCode;
	private String itemName;
	private String unitOfMrpGathering;
	private String claimDate;
	private String dueDate;
	private int necessaryAmount;
	private int mrpGatheringSeq;
	private String requestStatus;
	private String outsourceStatus;
	private ArrayList<MrpTO> mrpTOList;

}
