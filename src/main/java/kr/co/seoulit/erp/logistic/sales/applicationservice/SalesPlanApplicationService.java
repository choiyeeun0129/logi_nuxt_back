package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;

import kr.co.seoulit.erp.logistic.sales.to.SalesPlanTO;

public interface SalesPlanApplicationService {

	public ArrayList<SalesPlanTO> getSalesPlanList(String dateSearchCondition, String startDate, String endDate);

	// ApplicationService 안에서만 호출
	public String getNewSalesPlanNo(String salesPlanDate);

	public void batchSalesPlanListProcess(SalesPlanTO salesPlanTOList);

	public ArrayList<SalesPlanTO> getSalesPlan();

	public  void UpdateSalesPlan(SalesPlanTO salesPlanTOList);

}

