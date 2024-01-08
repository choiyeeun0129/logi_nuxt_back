package kr.co.seoulit.erp.logistic.transvehicle.servicefacade;

import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import kr.co.seoulit.erp.logistic.transvehicle.dao.TransVehicleDAO;
import kr.co.seoulit.erp.logistic.transvehicle.to.TransVehicleTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TransVehicleServiceFacadeImpl implements TransVehicleServiceFacade{

    @Autowired
    private TransVehicleDAO transVehicleDAO;

    private ModelMap modelMap = new ModelMap();


    @Override
    public ModelMap allTransVehicleList() {
        ArrayList<TransVehicleTO> vehicleList=transVehicleDAO.allTransVehicleList();
        try{
            modelMap.put("vehicleList", vehicleList); //명칭통일필요
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
    public ModelMap getTransVehicleList(String type) {
        ArrayList<TransVehicleTO> transVehicleList=transVehicleDAO.getTransVehicleList(type);
        try{
            modelMap.put("transVehicleList", transVehicleList); //명칭통일필요
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
    public Map<String, Object> addNewVehicle(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        try {
            String getNum = transVehicleDAO.getTransVehicleMaxNo().substring(2);
            int getNum2 = Integer.parseInt(getNum) + 1;

            System.out.println("bbbbbbb"+params.get("manufacturingCompany"));
            String lastNo;
            if (getNum2 >= 10) {
                lastNo = Integer.toString(getNum2);
            } else {
                lastNo = '0' + Integer.toString(getNum2);
            }
            String generatedVehicleNumber = "TR" + lastNo;

            params.put("vehicleNumber", generatedVehicleNumber);
            System.out.println(params.get("manufacturingCompany"));

            // 운송수단 등록
            transVehicleDAO.addNewVehicle(params);


            // 결과에 자동 생성된 차량 번호 추가
            result.put("generatedVehicleNumber", generatedVehicleNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");
        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

    @Override
    public void updateTransVehicle(TransVehicleTO transList) {
        transVehicleDAO.updateTransVehicle(transList);
    }

    @Override
    public void deleteTransVehicle(String vehicleNumber) {
        transVehicleDAO.deleteTransVehicle(vehicleNumber);
    }
}
