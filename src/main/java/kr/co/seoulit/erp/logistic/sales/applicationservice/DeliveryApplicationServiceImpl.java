package kr.co.seoulit.erp.logistic.sales.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.sales.dao.DeliveryDAO;
import kr.co.seoulit.erp.logistic.sales.to.DeliveryInfoTO;

@Component
public class DeliveryApplicationServiceImpl implements DeliveryApplicationService {

	@Autowired
	private DeliveryDAO deliveryDAO;

	@Override
	public ArrayList<DeliveryInfoTO> getDeliveryInfoList() {

		return deliveryDAO.selectDeliveryInfoList();
	}

	@Override
	public HashMap<String, Object> batchDeliveryListProcess(List<DeliveryInfoTO> deliveryTOList) {

		HashMap<String, Object> resultMap = new HashMap<>();

		ArrayList<String> insertList = new ArrayList<>();
		ArrayList<String> updateList = new ArrayList<>();
		ArrayList<String> deleteList = new ArrayList<>();

		for (DeliveryInfoTO bean : deliveryTOList) {

			String status = bean.getStatus();

			switch (status.toUpperCase()) {

			case "INSERT":

				// 새로운 일련번호 생성
				String newDeliveryNo = "새로운";

				// Bean 에 새로운 일련번호 세팅
				bean.setDeliveryNo(newDeliveryNo);
				deliveryDAO.insertDeliveryResult(bean);
				insertList.add(newDeliveryNo);

				break;

			case "UPDATE":

				deliveryDAO.updateDeliveryResult(bean);

				updateList.add(bean.getDeliveryNo());

				break;

			case "DELETE":

				deliveryDAO.deleteDeliveryResult(bean);

				deleteList.add(bean.getDeliveryNo());

				break;

			}

		}

		resultMap.put("INSERT", insertList);
		resultMap.put("UPDATE", updateList);
		resultMap.put("DELETE", deleteList);

		return resultMap;
	}

	@Override
	public HashMap<String, Object> deliver(String contractDetailNo) {

		HashMap<String, Object> param = new HashMap<>();
		param.put("contractDetailNo", contractDetailNo);

		deliveryDAO.deliver(param);

		return param;
	}

	// 미노
	@Override
	public Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate(Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate) {

		for (DeliveryInfoTO deliverUpdate1 : deliverUpdate.get("deliverUpdate")) {
			System.out.println("deliverUpdate1L:::::::::" + deliverUpdate1);
			deliverUpdate1.setFinalizeStatus("Y");

			System.out.println("deliverUpdate1L:::::::::" + deliverUpdate1);
			deliveryDAO.deliverUpdate(deliverUpdate1);

		}

		return deliverUpdate;

	}

}
