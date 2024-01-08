package kr.co.seoulit.erp.logistic.sales.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.sales.to.EstimateDetailTO;
import kr.co.seoulit.erp.logistic.sales.to.logisticExelTO;

@Mapper
public interface EstimateDetailDAO {

	public ArrayList<EstimateDetailTO> selectEstimateDetailList(String estimateNo);


//************************* 2020.08.27 63기 양지훈 수정 시작 *************************
//	description:	새로운 견적상세번호 생성 4차 설재영님 소스 가져옴
//
//	public int selectEstimateDetailCount(String estimateNo);
	public ArrayList<EstimateDetailTO> selectEstimateDetailCount(String estimateNo);

//
//************************* 2020.08.27 63기 양지훈 수정 종료 *************************
	public void insertEstimateDetail(EstimateDetailTO TO);

	public void updateEstimateDetail(EstimateDetailTO TO);

	public void deleteEstimateDetail(EstimateDetailTO TO);

	public ArrayList<logisticExelTO> selectLogisticExel(String estimateNo);

	//public void updateDueDateOfEstimate(EstimateDetailTO estimateDetailTO);
	public void updateDueDateOfEstimate(EstimateDetailTO estimateDetailTO);

}
