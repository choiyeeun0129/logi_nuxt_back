package kr.co.seoulit.erp.logistic.sales.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.sales.to.DeliveryInfoTO;

@Mapper
public interface DeliveryDAO {

	public ArrayList<DeliveryInfoTO> selectDeliveryInfoList();

	public HashMap<String, Object> deliver(HashMap<String, Object> param);

	public void insertDeliveryResult(DeliveryInfoTO TO);

	public void updateDeliveryResult(DeliveryInfoTO TO);

	public void deleteDeliveryResult(DeliveryInfoTO TO);

	public void deliverUpdate(DeliveryInfoTO TO);
}
