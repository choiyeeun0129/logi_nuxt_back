package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.sales.to.EstimateDetailTO;
import kr.co.seoulit.erp.logistic.sales.to.EstimateTO;
import kr.co.seoulit.erp.logistic.sales.to.logisticExelTO;

public interface EstimateApplicationService {

	public ArrayList<EstimateTO> getEstimateList(String dateSearchCondition, String startDate, String endDate);

	public ArrayList<EstimateDetailTO> getEstimateDetailList(String estimateNo);

	public ArrayList<logisticExelTO> getLogisticExel(String estimateNo);

	// ApplicationService 안에서만 호출
	public String getNewEstimateNo(String estimateDate);

	public HashMap<String, Object> addNewEstimate(String estimateDate, EstimateTO newEstimateTO);

	public HashMap<String, Object> batchEstimateDetailListProcess(ArrayList<EstimateDetailTO> estimateDetailTOList);

}