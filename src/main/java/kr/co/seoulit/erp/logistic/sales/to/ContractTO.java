package kr.co.seoulit.erp.logistic.sales.to;

import java.util.ArrayList;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

//************************* 2020.09.05 63기 양지훈 수정 시작 *************************
//description:	필드 deliveryCompletionStatus 추가;
//				필드 순서 변경
@Data
@EqualsAndHashCode(callSuper = false)
public class ContractTO extends BaseTO {
	private String contractNo;
	private String estimateNo;
	private String contractType;
	private String customerCode;
	private String contractDate;
	private String contractRequester;
	private String personCodeInCharge;
	private String description;
	private String deliveryCompletionStatus;
	private ArrayList<ContractDetailTO> contractDetailTOList;
}
//************************* 2020.09.05 63기 양지훈 수정 종료 *************************