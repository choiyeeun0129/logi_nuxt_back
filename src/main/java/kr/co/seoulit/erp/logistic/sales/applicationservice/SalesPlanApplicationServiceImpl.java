package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.hr.company.to.CompanyTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.sales.dao.SalesPlanDAO;
import kr.co.seoulit.erp.logistic.sales.to.SalesPlanTO;

@SuppressWarnings("unused")
@Component
public class SalesPlanApplicationServiceImpl implements SalesPlanApplicationService {

	@Autowired
	private SalesPlanDAO salesPlanDAO;

	public ArrayList<SalesPlanTO> getSalesPlanList(String dateSearchCondition, String startDate, String endDate) {

		HashMap<String, String> param = new HashMap<>();
		param.put("dateSearchCondition", dateSearchCondition);
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		return salesPlanDAO.selectSalesPlanList(param);
	}

	public String getNewSalesPlanNo(String salesPlanDate) {

		StringBuffer newEstimateNo = null;

		int newNo = salesPlanDAO.selectSalesPlanCount(salesPlanDate);

		newEstimateNo = new StringBuffer();

		newEstimateNo.append("SA");
		newEstimateNo.append(salesPlanDate.replace("-", ""));
		newEstimateNo.append(String.format("%02d", newNo)); // 2자리 숫자

		return newEstimateNo.toString();
	}

	@Override
	public void batchSalesPlanListProcess(SalesPlanTO salesPlanTOList) {

		System.out.println("@@@@@@@@@@@@@@@@@@@" + salesPlanTOList);
		salesPlanDAO.insertSalesPlan(salesPlanTOList);
		/*		HashMap<String, Object> resultMap = new HashMap<>();*/

		/*	ArrayList<String> insertList = new ArrayList<>();*/
		/*ArrayList<String> updateList = new ArrayList<>();
		ArrayList<String> deleteList = new ArrayList<>();
		System.out.println("####::" + salesPlanTOList.getStatus());*/

		/*String status = salesPlanTOList.getStatus();

		switch (status) {

		case "INSERT":*/

		// 새로운 판매계획일련번호 생성
		/*String newSalesPlanNo = getNewSalesPlanNo(salesPlanTOList.getSalesPlanDate());*/

		// Bean 에 새로운 판매계획일련번호 세팅
		/*salesPlanTOList.setSalesPlanNo(newSalesPlanNo);*/



		/*insertList.add(newSalesPlanNo);*/


		/*case "UPDATE":

			salesPlanDAO.updateSalesPlan(salesPlanTOList);

			updateList.add(salesPlanTOList.getSalesPlanNo());

			break;

		case "DELETE":

			salesPlanDAO.deleteSalesPlan(salesPlanTOList);

			deleteList.add(salesPlanTOList.getSalesPlanNo());

			break;

		}*/

	}
	public ArrayList<SalesPlanTO> getSalesPlan() {

		return salesPlanDAO.getSalesPlan();

	}

	public  void UpdateSalesPlan(SalesPlanTO salesPlanTOList){

		salesPlanDAO.updateSalesPlan( salesPlanTOList);
	}

}
