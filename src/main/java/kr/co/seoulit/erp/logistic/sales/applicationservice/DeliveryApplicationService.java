package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.seoulit.erp.logistic.sales.to.DeliveryInfoTO;

public interface DeliveryApplicationService {

	public ArrayList<DeliveryInfoTO> getDeliveryInfoList();

	public HashMap<String, Object> batchDeliveryListProcess(List<DeliveryInfoTO> deliveryTOList);

	public HashMap<String, Object> deliver(String contractDetailNo);

	public Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate(Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate);



}
