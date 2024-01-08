package kr.co.seoulit.erp.logistic.sales.dao;

import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.to.ClientDeliveryTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.Map;

@Mapper
public interface ClientDeliveryDAO {
    public ArrayList<ClientDeliveryTO> getClientDeliveryList();
    public String getClientDeliveryMaxNo();
    void addNewClientDelivery(Map<String, Object> params);

    public void updateClientDelivery(ClientDelivery clientDelivery);
    public void deleteClientDelivery(String deliveryNumber);
}
