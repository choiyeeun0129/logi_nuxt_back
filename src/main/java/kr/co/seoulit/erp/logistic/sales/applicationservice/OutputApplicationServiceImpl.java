package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.dao.ContractDAO;
import kr.co.seoulit.erp.logistic.sales.dao.OutputDAO;
import kr.co.seoulit.erp.logistic.sales.to.OutputTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OutputApplicationServiceImpl implements OutputApplicationService{

    private ModelMap modelMap=new ModelMap();
    @Autowired
    private OutputDAO outputDAO;

    @Autowired
    private ContractDAO contractDAO;

    public ModelMap getOutputList() {
        try {

            ArrayList<OutputTO> outputList = outputDAO.getOutputList();
            modelMap.put("outputList", outputList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @Override
    public ModelMap getOutputDetailList(String outputNumber) {
        Iterable<OutputTO> outputDetailList= outputDAO.getOutputDetailList(outputNumber);
        modelMap.put("outputInfo", outputDetailList);

        return modelMap;
    }

    // 출고번호생성
    @Override
    public Map<String, Object> addNewOutput(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 출고번호 생성
            String getNum = outputDAO.getOutputMaxNo().substring(2);
            int getNum2 = Integer.parseInt(getNum)+1;

            String lastNo;
            if (getNum2 >= 10) {
                lastNo = Integer.toString(getNum2);
            } else {
                lastNo = '0' + Integer.toString(getNum2);
            }
            String generatedOutputNumber = "SR" + lastNo;

            params.put("outputNumber", generatedOutputNumber);

            outputDAO.addNewOutput(params);

            // 결과에 생성된 출고번호 추가
            result.put("generatedOutputNumber", generatedOutputNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");

            String contractNo = (String) params.get("contractNo");
            contractDAO.delete(contractNo);

        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

//    @Override
//    public void insertOutput(OutputTO outputList) {
//        outputDAO.insertOutput(outputList);
//    }

    @Override
    public void deleteOutput(String outputNumber) {
        outputDAO.deleteOutput(outputNumber);
    }
}
