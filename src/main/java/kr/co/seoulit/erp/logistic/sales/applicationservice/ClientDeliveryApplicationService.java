package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.transvehicle.to.TransVehicleTO;
import org.springframework.ui.ModelMap;

import java.util.Map;

public interface ClientDeliveryApplicationService {
    public ModelMap getClientDeliveryList();

    public Map<String, Object> addNewClientDelivery(Map<String, Object> params);

    public void updateClientDelivery(ClientDelivery clientDelivery);


    public void deleteClientDelivery(String deliveryNumber);
}
