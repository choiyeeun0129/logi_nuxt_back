package kr.co.seoulit.erp.logistic.outsourcing.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.logistic.outsourcing.applicationservice.OutsourcApplicationService;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutInspectionTO;
import kr.co.seoulit.erp.logistic.outsourcing.to.OutsourcTO;
import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;

@Component
public class OutsourcServiceFacadeImpl implements OutsourcServiceFacade{
	
	@Autowired
	private OutsourcApplicationService outsourcAS;

	@Override
	public ArrayList<MrpGatheringTO> searchMrpGatheringList(
			String dateSearchCondtion,
			String startDate,
			String endDate) {

		return outsourcAS.searchMrpGatheringList(
				dateSearchCondtion,
				startDate,
				endDate);
	}

	@Override
	public int getStandardUnitPrice(String itemCode) {
		return outsourcAS.getStandardUnitPrice(itemCode);
	}

	@Override
	public void insertOutsourc(ArrayList<OutsourcTO> outsourcList) {
		outsourcAS.insertOutsourc(outsourcList);
	}

	@Override
	public ArrayList<OutsourcTO> searchOutsourcInfoList(String searchDateCondition, String startDate, String endDate) {
		return outsourcAS.searchOutsourcInfoList(searchDateCondition, startDate, endDate);
	}

	
	@Override
	public HashMap<String,Object> getReleaseSimulationList(String mrpGatheringNo, String id, String seq) {

		return outsourcAS.getReleaseSimulationList(mrpGatheringNo, id, seq);
		
	}
	
	@Override
	public void updateStock(String itemCode,String mrpGatheringNo, String id, String seq) {

    	outsourcAS.updateStock(itemCode,mrpGatheringNo, id, seq);	
	}
	
	@Override
	public ArrayList<OutInspectionTO> getOutInspectionInfoList() {

		return outsourcAS.getOutInspectionInfoList();
		
}
	@Override
	public HashMap<String,Object> outInspectionCompletion(String outsourcNo
//			,String actualCompletionAmount
	) {

    	return outsourcAS.outInspectionCompletion(outsourcNo
//				,actualCompletionAmount
		);
		
	}

	@Override
	public ArrayList<OutsourcTO> searchForwardableList(String searchDateCondition, String startDate, String endDate) {

		return outsourcAS.searchForwardableList(searchDateCondition, startDate, endDate);
	}

	@Override
	public void forwardTempDelete(String id, String seq) {
		outsourcAS.forwardTempDelete(id, seq);
		
	}

	@Override
	public ArrayList<OutsourcTO> searchOutsourcInfoList() {
		return outsourcAS.searchOutsourcInfoList();
	}

	@Override
	public void updateForwardStatus(String outsourcNo) {
		outsourcAS.updateForwardStatus(outsourcNo);
	}


}
