package kr.co.seoulit.erp.logistic.purchase.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.purchase.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.purchase.applicationservice.BomApplicationService;
import kr.co.seoulit.erp.logistic.purchase.applicationservice.OrderApplicationService;
import kr.co.seoulit.erp.logistic.purchase.applicationservice.StockApplicationService;
import kr.co.seoulit.erp.logistic.purchase.to.BomDeployTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomInfoTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderDialogTempTO;
import kr.co.seoulit.erp.logistic.purchase.to.OrderInfoTO;
import kr.co.seoulit.erp.logistic.purchase.to.StockLogTO;
import kr.co.seoulit.erp.logistic.purchase.to.StockTO;

@Component
public class PurchaseServiceFacadeImpl implements PurchaseServiceFacade {

	@Autowired
	private BomApplicationService bomAS;
	@Autowired
	private OrderApplicationService orderAS;
	@Autowired
	private StockApplicationService stockAS;
	@Autowired
	private StockDAO stockDAO;

	@Override
	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode,
												   String itemClassificationCondition) {

		return bomAS.getBomDeployList(deployCondition, itemCode, itemClassificationCondition);
	}

	@Override
	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode) {

		return bomAS.getBomInfoList(parentItemCode);
	}

	@Override
	public HashMap<String, Object> getOrderList(String startDate, String endDate) {

		return orderAS.getOrderList(startDate, endDate);
	}

	@Override
	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable() {

		return bomAS.getAllItemWithBomRegisterAvailable();
	}

	@Override
	public HashMap<String, Object> batchBomListProcess(ArrayList<BomTO> batchBomList) {

		return bomAS.batchBomListProcess(batchBomList);

	}

	@Override
	public HashMap<String, Object> getOrderDialogInfo(ArrayList<String> mrpNoArr) {

		return orderAS.getOrderDialogInfo(mrpNoArr);

	}

	@Override
	public ArrayList<OrderDialogTempTO> getOrderDialog() {

		return orderAS.getOrderDialog();

	}

	@Override
	public HashMap<String, Object> order(ArrayList<String> mrpGatheringNoList) {

		return orderAS.order(mrpGatheringNoList);

	}

	@Override
	public HashMap<String, Object> optionOrder(String itemCode, String itemAmount) {

		return orderAS.optionOrder(itemCode, itemAmount);

	}

	@Override
	public ArrayList<StockTO> getStockList() {

		return stockAS.getStockList();

	}

	@Override
	public ArrayList<StockTO> getWarehouseStockList(String warehouseCode) {
		System.out.println("서비스임플까지");
		System.out.println(warehouseCode);
		ArrayList<StockTO> stockList = null;

		stockList = stockDAO.selectWarehouseStockList(warehouseCode);
		System.out.println(warehouseCode);

		return stockList;
	}

	@Override
	public ArrayList<StockLogTO> getStockLogList(String startDate, String endDate) {

		return stockAS.getStockLogList(startDate, endDate);
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoListOnDelivery() {

		return orderAS.getOrderInfoListOnDelivery();

	}

	@Override
	public HashMap<String, Object> warehousing(ArrayList<String> orderNoArr) {

		return stockAS.warehousing(orderNoArr);
	}

	@Override
	public ArrayList<OrderInfoTO> getOrderInfoList(String startDate, String endDate) {

		return orderAS.getOrderInfoList(startDate, endDate);

	}

	@Override
	public void inspection(String orderNoArr) {

		stockAS.inspection(orderNoArr);
	}

	@Override
	public void updateOrderInfo(ArrayList<OrderInfoTO> list) {
		// TODO Auto-generated method stub
		orderAS.updateOrderInfo(list);
	}

	//dbs
	@Override
	public ArrayList<BomDeployTO> getBomDataList(String itemCode,
												 String itemClassificationCondition) {

		return bomAS.getBomDataList(itemCode, itemClassificationCondition);
	}
}
