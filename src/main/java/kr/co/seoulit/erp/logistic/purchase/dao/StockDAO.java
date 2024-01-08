package kr.co.seoulit.erp.logistic.purchase.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.purchase.to.StockLogTO;
import kr.co.seoulit.erp.logistic.purchase.to.StockTO;

@Mapper
public interface StockDAO {

	public ArrayList<StockTO> selectWarehouseStockList(String warehouseCode);


	public ArrayList<StockTO> selectStockList();

	public HashMap<String, Object> warehousing(HashMap<String, Object> resultMap);

	public ArrayList<StockLogTO> selectStockLogList(HashMap<String, String> param);

	public void inspection(HashMap<String, String> param);

}