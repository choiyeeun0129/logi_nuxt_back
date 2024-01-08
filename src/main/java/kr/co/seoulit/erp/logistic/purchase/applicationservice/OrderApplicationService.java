package kr.co.seoulit.erp.logistic.purchase.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.purchase.to.OrderDialogTempTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderInfoTO;

public interface OrderApplicationService {

	public HashMap<String, Object> getOrderList(String startDate, String endDate);

	public HashMap<String, Object> getOrderDialogInfo(ArrayList<String> mrpNoArr);

	public ArrayList<OrderDialogTempTO> getOrderDialog();

	public void updateOrderInfo(ArrayList<OrderInfoTO> list);

	public HashMap<String, Object> order(ArrayList<String> mrpGatheringNoList);

	public HashMap<String, Object> optionOrder(String itemCode, String itemAmount);

	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery();

	public ArrayList<OrderInfoTO> getOrderInfoList(String startDate, String endDate);

}
