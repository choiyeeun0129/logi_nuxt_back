package kr.co.seoulit.erp.logistic.purchase.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.purchase.to.StockLogTO;
import kr.co.seoulit.erp.logistic.purchase.to.StockTO;

public interface StockApplicationService {

	public ArrayList<StockTO> getStockList();

	public ArrayList<StockLogTO> getStockLogList(String startDate, String endDate);

	public HashMap<String, Object> warehousing(ArrayList<String> orderNoArr);

	public void inspection(String orderNoList);

}
