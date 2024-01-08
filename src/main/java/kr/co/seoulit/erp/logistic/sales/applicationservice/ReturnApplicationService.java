package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.to.ReturnTO;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ReturnApplicationService {
    public HashMap<String, Object> getReturnList(String startDate, String endDate);

    public ModelMap returnListForStock();

    public void updateReturn(ReturnTO returnList);

    public void deleteReturn(String returnNo);

    public Map<String, Object> addReturn(Map<String, Object> params);
}
