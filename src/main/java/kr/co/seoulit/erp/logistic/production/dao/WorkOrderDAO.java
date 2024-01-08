package kr.co.seoulit.erp.logistic.production.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.production.to.WorkOrderInfoTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkOrderDAO {

	//작업지시 Tab -  작업지시 필요항목 조회
	public HashMap<String, Object> getWorkOrderableMrpList(HashMap<String, Object> result);

	//작업지시 Tab -  작업지시 모의전개
	public HashMap<String, Object> getWorkOrderSimulationList(HashMap<String, Object> param);

	//작업지시 Tab - 작업지시 모의전개 버튼 누른 후 - 실제 작업 지시 버튼
	public HashMap<String, Object> workOrder(HashMap<String, Object> param);

	//작업지시현황 Tab - 작업지시현황조회
	public ArrayList<WorkOrderInfoTO> selectWorkOrderInfoListStatus();

	//작업지시현황 Tab - 작업완료된수량입력
	public int editActualAmount(@Param("workOrderNo") String workOrderNo,
								@Param("actualCompletionAmount") String actualCompletionAmount);

	//작업지시현황 Tab - 작업완료등록
	public HashMap<String, Object> workOrderCompletion(HashMap<String, Object> param);

	//생산실적관리 Tab - 생산실적관리조회
	//public ArrayList<ProductionPerformanceInfoTO> selectProductionPerformanceInfoList();










	public ArrayList<WorkOrderInfoTO> selectWorkOrderInfoList();

	public HashMap<String, Object> selectWorkSiteSituation(HashMap<String, Object> param);
	public void updateWorkCompletionStatus(HashMap<String, Object> param);












	public List<WorkSiteLogTO> workSiteLogList(String workSiteLogDate);







	public ArrayList<WorkSiteLogTO> selectProductionProcessCode(HashMap<String, String> map);

}
