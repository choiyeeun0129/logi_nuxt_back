package kr.co.seoulit.erp.logistic.sales.to;

import java.util.ArrayList;


import javax.persistence.Transient;

import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstimateTO extends BaseTO {
	private String effectiveDate;
	private String estimateNo;
	private String estimateRequester;
	private String description;
	private String contractStatus;
	private String customerCode;

//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//	description:	React View에서 거래처명도 함께 보냈는데 JVM이 customerName을 TO에 넣어라고 해서 넣음
//
	@Transient
	private String customerName;
//************************* 2020.08.27 63기 양지훈 수정 종료 *************************

	private String personCodeInCharge;
	private String personNameCharge;
	private String estimateDate;
	private ArrayList<EstimateDetailTO> estimateDetailTOList;

}
