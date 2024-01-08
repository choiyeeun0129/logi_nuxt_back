package kr.co.seoulit.erp.logistic.purchase.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.purchase.to.OrderDialogTempTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderInfoTO;

@Mapper
public interface OrderDAO {

	public HashMap<String, Object> getOrderDialogInfo(HashMap<String, Object> resultMap);

	public ArrayList<OrderDialogTempTO> getOrderDialog();

	public void updateOrderInfo(OrderInfoTO list);

	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery();

	public HashMap<String, Object> order(HashMap<String, Object> resultMap);

	public HashMap<String, Object> getOrderList(HashMap<String, String> param);

	public HashMap<String, Object> optionOrder(HashMap<String, Object> param);

	public ArrayList<OrderInfoTO> getOrderInfoList(HashMap<String, Object> param);

}
