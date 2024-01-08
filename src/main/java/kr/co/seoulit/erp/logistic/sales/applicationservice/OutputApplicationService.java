package kr.co.seoulit.erp.logistic.sales.applicationservice;

import org.springframework.ui.ModelMap;

import java.util.Map;

public interface OutputApplicationService {
    public ModelMap getOutputList();
    public ModelMap getOutputDetailList(String outputNumber);

//    public void insertOutput(OutputTO outputList);
    public Map<String, Object> addNewOutput(Map<String, Object> params);

    public void deleteOutput(String outputNumber);
}
