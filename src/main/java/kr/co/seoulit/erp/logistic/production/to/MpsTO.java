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
@Table(name="mps")
public class MpsTO  extends BaseTO{

	@Id
	private String mpsNo;
	private String mpsPlanDate;
	private String contractDetailNo;
	private String dueDateOfMps; // 납기일
	private String salesPlanNo;
	private String itemCode;
	private String itemName;
	private String mpsPlanAmount;
	private String mrpApplyStatus;
	private String description;
	private String unitOfMps;
	private String mpsPlanClassification;
	private String scheduledEndDate; // 출하예정일

	public MpsTO(){

	}
	public MpsTO (ContractDetailInMpsAvailableTO contractDetail) {
		this.setMpsPlanDate(contractDetail.getMpsPlanDate());
		this.setContractDetailNo(contractDetail.getContractDetailNo());
		this.setItemCode(contractDetail.getItemCode());
		this.setItemName(contractDetail.getItemName());
		this.setUnitOfMps(contractDetail.getUnitOfContract());
		this.setDueDateOfMps(contractDetail.getDueDateOfContract());
		this.setScheduledEndDate(contractDetail.getScheduledEndDate());
		this.setDescription(contractDetail.getDescription());
		this.setMpsPlanAmount(contractDetail.getEstimateAmount());
		this.setMpsPlanClassification(contractDetail.getPlanClassification());
	}

	public MpsTO(SalesPlan salesPlan) {
		this.mpsPlanDate			=  salesPlan.getMpsPlanDate();
		this.scheduledEndDate		=  salesPlan.getScheduledEndDate();
		this.dueDateOfMps			=  salesPlan.getDueDateOfSales();
		this.salesPlanNo			=  salesPlan.getSalesPlanNo();
		this.itemCode				=  salesPlan.getItemCode();
		this.itemName				=  salesPlan.getItemName();
		this.mpsPlanAmount			=  salesPlan.getSalesAmount();
		this.mrpApplyStatus			=  salesPlan.getMpsApplyStatus();
		this.description			=  salesPlan.getDescription();
		this.unitOfMps				=  salesPlan.getUnitOfSales();
		this.mpsPlanClassification	=  salesPlan.getPlanClassification();
	}
}
