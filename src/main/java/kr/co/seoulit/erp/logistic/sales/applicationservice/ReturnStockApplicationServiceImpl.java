package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.dao.ReturnStockDAO;
import kr.co.seoulit.erp.logistic.sales.to.ReturnStockTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ReturnStockApplicationServiceImpl implements ReturnStockApplicationService {
    private ModelMap modelMap = new ModelMap();

    @Autowired
    private ReturnStockDAO returnStockDAO;

    @Override
	public ArrayList<ReturnStockTO> searchReturnStockList(String itemCode) {

		return returnStockDAO.searchReturnStockList(itemCode);
	}

//    @Override
//    public ModelMap returnListForStock() {
//        ArrayList<ReturnTO> returnListForStock=returnDAO.returnListForStock();
//        try{
//            modelMap.put("returnListForStock", returnListForStock);
//            modelMap.put("errorCode", 1);
//            modelMap.put("errorMsg", "성공");
//        }catch(Exception e){
//            e.printStackTrace();
//            modelMap.put("errorCode", -2);
//            modelMap.put("errorMsg", e.getMessage());
//        }
//        return modelMap;
//    }
//
//    @Override
//    public void updateReturn(ReturnTO returnList) {
//        returnDAO.updateReturn(returnList);
//    }

    @Override
    public void deleteReturnStock(String rtrnRecNo) {
        returnStockDAO.deleteReturnStock(rtrnRecNo);
    }

    @Override
    public Map<String, Object> addReturnStock(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        try {
            System.out.println("노아");
            //반품재고입고번호 생성
            String getNum = returnStockDAO.getRtrnRecMaxNo().substring(3);
            int getNum2 = Integer.parseInt(getNum) + 2;

            String lastNo;
            if (getNum2 >= 10) {
                lastNo = Integer.toString(getNum2);
            } else {
                lastNo = '0' + Integer.toString(getNum2);
            }
            String generatedRtrnRecNo = "REC" + lastNo;

            params.put("rtrnRecNo", generatedRtrnRecNo);

            // 반품재고입고요청 등록
            System.out.println("여기요요요요");
            System.out.println("params = " + params);
            returnStockDAO.addReturnStock(params);

            // 결과에 자동 생성된 반품 번호 추가
            result.put("generatedRtrnRecNo", generatedRtrnRecNo);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");


        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }
        return result;
    }
}

