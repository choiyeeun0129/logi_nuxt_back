package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.to.ReturnStockTO;

import java.util.ArrayList;
import java.util.Map;

public interface ReturnStockApplicationService {
   public ArrayList<ReturnStockTO> searchReturnStockList(String itemCode);

//    public ModelMap returnListForStock();
//
//    public void updateReturn(ReturnTO returnList);

    public void deleteReturnStock(String rtrnRecNo);

    public Map<String, Object> addReturnStock(Map<String, Object> params);
}
