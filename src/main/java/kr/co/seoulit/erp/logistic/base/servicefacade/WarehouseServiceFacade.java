package kr.co.seoulit.erp.logistic.base.servicefacade;

import java.util.List;

import kr.co.seoulit.erp.logistic.base.to.WarehouseTO;
import org.springframework.ui.ModelMap;

public interface WarehouseServiceFacade {

	public ModelMap getWarehouseInfoList();

	public void batchWarehouseInfoProcess(List<WarehouseTO> warehouseList);



}
