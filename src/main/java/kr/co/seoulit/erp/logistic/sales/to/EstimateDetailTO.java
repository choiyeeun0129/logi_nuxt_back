package kr.co.seoulit.erp.logistic.sales.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.namespace.QName;

import kr.co.seoulit.common.to.BaseTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "ESTIMATE_DETAIL")
public class EstimateDetailTO extends BaseTO {

//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//	description:	React View에서 rowId라는 행 index 값 나타내는 변수;
//
	@Transient
	private String rowId;
//************************* 2020.08.27 63기 양지훈 수정 종료 *************************
	private String unitOfEstimate;
	private String estimateNo;
	private int unitPriceOfEstimate;
	@Id
	private String estimateDetailNo;
	private int sumPriceOfEstimate;
	private String description;
	private String itemCode;
	private int estimateAmount;
	private String dueDateOfEstimate;
	private String itemName;
}
