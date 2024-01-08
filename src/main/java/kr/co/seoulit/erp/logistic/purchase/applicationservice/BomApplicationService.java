package kr.co.seoulit.erp.logistic.purchase.applicationservice;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.purchase.to.BomDeployTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomInfoTO;
import kr.co.seoulit.erp.logistic.purchase.to.BomTO;

public interface BomApplicationService {

	public ArrayList<BomDeployTO> getBomDeployList(String deployCondition, String itemCode,
												   String itemClassificationCondition);

	public ArrayList<BomInfoTO> getBomInfoList(String parentItemCode);

	public ArrayList<BomInfoTO> getAllItemWithBomRegisterAvailable();

	public HashMap<String, Object> batchBomListProcess(ArrayList<BomTO> batchBomList);

	//dbs
	public ArrayList<BomDeployTO> getBomDataList(String itemCode,
												 String itemClassificationCondition);

}
