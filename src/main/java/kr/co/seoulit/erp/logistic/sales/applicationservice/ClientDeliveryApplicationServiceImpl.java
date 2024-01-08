package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.dao.ClientDeliveryDAO;
import kr.co.seoulit.erp.logistic.sales.dao.OutputDAO;
import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.to.ClientDeliveryTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ClientDeliveryApplicationServiceImpl implements ClientDeliveryApplicationService {
    private ModelMap modelMap=new ModelMap();
    @Autowired
    private ClientDeliveryDAO clientDeliveryDAO;

    @Autowired
    private OutputDAO outputDAO;

    @Override
    public ModelMap getClientDeliveryList() {
        try {

            ArrayList<ClientDeliveryTO> clientDeliveryList = clientDeliveryDAO.getClientDeliveryList();
            modelMap.put("clientDeliveryList", clientDeliveryList);
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
    public Map<String, Object> addNewClientDelivery(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 배송번호 생성
            String getNum = clientDeliveryDAO.getClientDeliveryMaxNo().substring(2);
            int getNum2 = Integer.parseInt(getNum)+1;

            String lastNo;
            if (getNum2 >= 10) {
                lastNo = Integer.toString(getNum2);
            } else {
                lastNo = '0' + Integer.toString(getNum2);
            }
            String generatedClientDeliveryNumber = "DN" + lastNo;

            params.put("deliveryNumber", generatedClientDeliveryNumber);

            clientDeliveryDAO.addNewClientDelivery(params);

            // 결과에 생성된 배송번호 추가
            result.put("generatedClientDeliveryNumber", generatedClientDeliveryNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");

            String outputNumber = (String) params.get("outputNumber");
            outputDAO.delete(outputNumber);

        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

    @Override
    public void updateClientDelivery(ClientDelivery clientDelivery) {
        clientDeliveryDAO.updateClientDelivery(clientDelivery);
    }

    @Override
    public void deleteClientDelivery(String deliveryNumber) {
        clientDeliveryDAO.deleteClientDelivery(deliveryNumber);
    }
}
