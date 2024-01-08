package kr.co.seoulit.erp.logistic.sales.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.production.to.SalesPlanInMpsAvailableTO;

import kr.co.seoulit.erp.logistic.sales.to.SalesPlanTO;

@Mapper
public interface SalesPlanDAO {

	public int selectSalesPlanCount(String salesPlanDate);

	public void insertSalesPlan(SalesPlanTO TO);



	public void deleteSalesPlan(SalesPlanTO TO);

	public ArrayList<SalesPlanInMpsAvailableTO> selectSalesPlanListInMpsAvailable(HashMap<String, String> param);

	public void changeMpsStatusOfSalesPlan(HashMap<String, String> param);

	public ArrayList<SalesPlanTO> selectSalesPlanList(HashMap<String, String> param);

	public ArrayList<SalesPlanTO> getSalesPlan();

	public void updateSalesPlan(SalesPlanTO salesPlanTOList);

}
