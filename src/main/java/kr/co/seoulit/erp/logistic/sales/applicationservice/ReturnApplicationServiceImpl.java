package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.dao.ReturnDAO;
import kr.co.seoulit.erp.logistic.sales.to.ReturnTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ReturnApplicationServiceImpl implements ReturnApplicationService {
    private ModelMap modelMap = new ModelMap();

    @Autowired
    private ReturnDAO returnDAO;

    @Override
    public HashMap<String, Object> getReturnList(String startDate, String endDate) {

        HashMap<String, String> param = new HashMap<>();
        param.put("startDate", startDate);
        param.put("endDate", endDate);

         // DAO에서 리스트를 가져오도록 수정
        ArrayList<ReturnTO> resultList = returnDAO.getReturnList(param);

        // 가져온 리스트를 param 맵에 설정
        param.put("result", String.valueOf(resultList));

        // 에러 코드 및 메시지를 설정할 수도 있습니다.
        param.put("ERROR_CODE", "0");
        param.put("ERROR_MSG", "Success");

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("gridRowJson", resultList); // 리스트 자체를 설정
        resultMap.put("errorCode", param.get("ERROR_CODE"));
        resultMap.put("errorMsg", param.get("ERROR_MSG"));
        System.out.println("@@ resultMap" + resultMap);
        return resultMap;
    }

    @Override
    public ModelMap returnListForStock() {
        ArrayList<ReturnTO> returnListForStock=returnDAO.returnListForStock();
        try{
            modelMap.put("returnListForStock", returnListForStock);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        }catch(Exception e){
            e.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e.getMessage());
        }
        return modelMap;
    }

    @Override
    public void updateReturn(ReturnTO returnList) {
        returnDAO.updateReturn(returnList);
    }

    @Override
    public void deleteReturn(String returnNo) {
        returnDAO.deleteReturn(returnNo);
    }

    @Override
    public Map<String, Object> addReturn(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        try {
            //반품번호 생성
            String getNum = returnDAO.getReturnMaxNo().substring(3);
            int getNum2 = Integer.parseInt(getNum) + 2;

            String lastNo;
            if (getNum2 >= 10) {
                lastNo = Integer.toString(getNum2);
            } else {
                lastNo = '0' + Integer.toString(getNum2);
            }
            String generatedReturnNumber = "RTN" + lastNo;

            params.put("returnNo", generatedReturnNumber);

            // 반품요청 등록
            returnDAO.addReturn(params);

            // 결과에 자동 생성된 반품 번호 추가
            result.put("generatedReturnNumber", generatedReturnNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");


        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }
        return result;
    }
}

