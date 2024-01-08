package kr.co.seoulit.erp.logistic.purchase.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.purchase.dao.OrderDAO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderDialogTempTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderInfoTO;

@Component
public class OrderApplicationServiceImpl implements OrderApplicationService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public HashMap<String, Object> getOrderList(String startDate, String endDate) {

//		HashMap<String,Object> param = new HashMap<>(); 
//		param.put("startDate",startDate);
//		param.put("endDate",endDate);
//		
//		orderDAO.getOrderList(param);
//		
//		return param;

		HashMap<String, String> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		orderDAO.getOrderList(param);

		HashMap<String, Object> resultMap = new HashMap<>();

		resultMap.put("gridRowJson", param.get("result"));
		resultMap.put("errorCode", param.get("ERROR_CODE"));
		resultMap.put("errorMsg", param.get("ERROR_MSG"));
		System.out.println("@@ resultMap" + param);
		return resultMap;
	}

	@Override
	public HashMap<String, Object> getOrderDialogInfo(ArrayList<String> mrpNoArr) {

		HashMap<String, Object> resultMap = new HashMap<>();

		String mrpNoList = mrpNoArr.toString().replace("[", "").replace("]", "");
		resultMap.put("mrpNoList", mrpNoList);

		orderDAO.getOrderDialogInfo(resultMap);

		return resultMap;
	}

	@Override
	public ArrayList<OrderDialogTempTO> getOrderDialog() {

		return orderDAO.getOrderDialog();
	}

	@Override
	public HashMap<String, Object> order(ArrayList<String> mrpGatheringNoList) {

		String mrpGatheringNo = mrpGatheringNoList.toString().replace("[", "").replace("]", "");
		HashMap<String, Object> resultMap = new HashMap<>();

		resultMap.put("mrpGatheringNoList", mrpGatheringNo);
		orderDAO.order(resultMap);
		return resultMap;

	}

	@Override
	public HashMap<String, Object> optionOrder(String itemCode, String itemAmount) {
		HashMap<String, Object> param = new HashMap<>();
		param.put("itemCode", itemCode);
		param.put("itemAmount", itemAmount);
		orderDAO.optionOrder(param);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("errorCode", param.get("errorCode"));
		resultMap.put("errorMsg", param.get("errorMsg"));
		return resultMap;
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery() {

		return orderDAO.getOrderInfoListOnDelivery();
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoList(String startDate, String endDate) {

		HashMap<String, Object> param = new HashMap<>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);

		return orderDAO.getOrderInfoList(param);

	}

	@Override
	public void updateOrderInfo(ArrayList<OrderInfoTO> list) {
		// TODO Auto-generated method stub
		for (OrderInfoTO orderTO : list)
			orderDAO.updateOrderInfo(orderTO);
	}

}
