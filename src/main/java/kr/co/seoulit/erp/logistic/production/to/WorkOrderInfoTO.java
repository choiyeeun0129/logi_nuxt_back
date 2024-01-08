package kr.co.seoulit.erp.logistic.production.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.co.seoulit.common.to.BaseTO;
import kr.co.seoulit.erp.logistic.production.domain.SalesPlan;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="workOrder")
public class WorkOrderInfoTO extends BaseTO{

	@Id
	private String workOrderNo;
	private String mrpNo;
	private String mpsNo;
	private String mrpGatheringNo;
	private String itemClassification;
	private String itemCode;
	private String itemName;
	private String unitOfMrp;
	private String requiredAmount;
	private String workSiteCode;
	private String workSiteName;
	private String productionProcessCode;
	private String productionProcessName;
	private String inspectionStatus;
	private String productionStatus;
	private String completionStatus;
	private String actualCompletionAmount;
}
