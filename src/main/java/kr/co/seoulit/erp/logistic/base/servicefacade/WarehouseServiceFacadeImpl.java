package kr.co.seoulit.erp.logistic.base.servicefacade;

import java.util.ArrayList;
import java.util.List;
import kr.co.seoulit.erp.logistic.base.dao.WarehouseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.seoulit.erp.logistic.base.to.WarehouseTO;
import org.springframework.ui.ModelMap;

@Service
public class WarehouseServiceFacadeImpl implements WarehouseServiceFacade {

	@Autowired
	private WarehouseDAO warehouseDAO;


	private ModelMap modelMap= new ModelMap();

	@Override
	public ModelMap getWarehouseInfoList() {
		try {
			ArrayList<WarehouseTO> WarehouseTOList = warehouseDAO.selectWarehouseList();
			modelMap.put("gridRowJson", WarehouseTOList);
			modelMap.put("errorCode", 1);
			modelMap.put("errorMsg", "성공");
		} catch (Exception e2) {
			e2.printStackTrace();
			modelMap.put("errorCode", -2);
			modelMap.put("errorMsg", e2.getMessage());
		}

		return modelMap;
	}

	public String createWarehouseCode() {
		int temporaryCode = warehouseDAO.createWarehouseCode();
		String warehouseCode = "WHS-" + String.format("%02d", temporaryCode + 1);
		return warehouseCode;
	}

	@Override
	public void batchWarehouseInfoProcess(List<WarehouseTO> warehouseList) {
		for (WarehouseTO bean : warehouseList) {
			String status = bean.getStatus();

			switch (status) {

				case "INSERT":

					String warehouseCode = createWarehouseCode();
					System.out.println("코드생성??" + warehouseCode);
					bean.setWarehouseCode(warehouseCode);
					bean.setStatus("normal");
					warehouseDAO.insertCode(bean);

					break;

				case "UPDATE":

					warehouseDAO.updateCode(bean);


					break;

				case "DELETE":

					warehouseDAO.deleteCode(bean);

					break;

			}
		}
	}
}
