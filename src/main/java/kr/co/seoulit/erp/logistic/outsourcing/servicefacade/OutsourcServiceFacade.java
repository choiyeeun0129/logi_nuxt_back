package kr.co.seoulit.erp.logistic.outsourcing.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.outsourcing.to.OutInspectionTO;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;
import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;

public interface OutsourcServiceFacade {
	
	public ArrayList<MrpGatheringTO> searchMrpGatheringList(
			String dateSearchCondtion,
			String startDate,
			String endDate);

	public int getStandardUnitPrice(String itemCode);

	public void insertOutsourc(ArrayList<OutsourcTO> outsourcList);

	public ArrayList<OutsourcTO> searchOutsourcInfoList(String searchDateCondition, String startDate, String endDate);

	public HashMap<String,Object> getReleaseSimulationList(String mrpGatheringNo, String id, String seq);
	
	public void updateStock(String itemCode,String mrpGatheringNo, String id, String seq);
	
	public ArrayList<OutInspectionTO> getOutInspectionInfoList();
	
	public HashMap<String,Object> outInspectionCompletion(String outsourcNo
//			,String actualCompletionAmount
	);

	public ArrayList<OutsourcTO> searchForwardableList(String searchDateCondition, String startDate, String endDate);

	public void forwardTempDelete(String id, String seq);

	public ArrayList<OutsourcTO> searchOutsourcInfoList();

	public void updateForwardStatus(String outsourcNo);
}
