package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.logistic.production.dao.WorkOrderDAO;
import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.repository.WorkOrderRepository;
import kr.co.seoulit.erp.logistic.production.to.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class WorkOrderServiceFacadeImpl implements WorkOrderServiceFacade {

    @Autowired
    private WorkOrderDAO workOrderDAO;
    @Autowired
    private WorkOrderRepository workOrderRepository;

    //작업지시 Tab -  작업지시 필요항목 조회
    @Override
    public HashMap<String, Object> getWorkOrderableMrpList() {

        HashMap<String, Object> result = new HashMap<>();
        HashMap<String, Object> map = new HashMap<>();

        workOrderDAO.getWorkOrderableMrpList(map);

        result.put("gridRowJson", map.get("result"));
        result.put("errorCode", map.get("errorCode"));
        result.put("errorMsg", map.get("errorMsg"));

        System.out.println("데이터확인용");
        System.out.println(result);

        return result;
    }

    //작업지시 Tab -  작업지시 모의전개
    @Override
    public HashMap<String, Object> getWorkOrderSimulationList(String mrpNo,String mrpGatheringNo) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("mrpGatheringNo", mrpGatheringNo);
        param.put("mrpNo", mrpNo);

        workOrderDAO.getWorkOrderSimulationList(param);

        System.out.println("작업지시 모의전개1 : "+param);

        HashMap<String, Object> map = new HashMap<>();
        map.put("result",param.get("result"));
        map.put("errorCode",param.get("ERROR_CODE"));
        map.put("errorMsg",param.get("ERROR_MSG"));
        System.out.println("작업지시 모의전개2 : "+map);

        return param;
    }

    //작업지시 Tab - 작업지시 모의전개 버튼 누른 후 - 실제 작업 지시 버튼
    @Override
    public HashMap<String, Object> workOrder(String mrpGatheringNo, String workPlaceCode, String productionProcessCode) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("mrpGatheringNo", mrpGatheringNo);
        param.put("workPlaceCode", workPlaceCode);
        param.put("productionProcessCode", productionProcessCode);

        System.out.println("S_mrpGatheringNo: "+mrpGatheringNo);
        System.out.println("S_workPlaceCode: "+workPlaceCode);
        System.out.println("S_productionProcessCode: "+productionProcessCode);

        workOrderDAO.workOrder(param);

        return param;
    }

    /************************************
     작업지시현황 Tab - 작업지시현황조회(JPA)
     ************************************/
    @Transactional
    public List<WorkOrderInfo> getWorkOrderInfoListStatus() {
        System.out.println("작업지시현황조회_ServiceFacadeImpl");
        List<WorkOrderInfo> workOrderInfoList = workOrderRepository.findAll();
        return workOrderInfoList;
    }

//    작업지시현황 Tab - 작업지시현황조회(Spring)
//    @Override
//    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoListStatus() {
//        return workOrderDAO.selectWorkOrderInfoListStatus();
//    }


    //작업완료된 수량 입력
    @Override
    public int editActualAmount(String workOrderNo, String actualCompletionAmount) {
        int count = workOrderDAO.editActualAmount(workOrderNo, actualCompletionAmount);
        return count;
    }

    //작업지시현황 Tab - 작업완료등록
    @Override
    public HashMap<String, Object> workOrderCompletion(String workOrderNo, String actualCompletionAmount) {

        HashMap<String, Object> param = new HashMap<>();
        param.put("workOrderNo", workOrderNo);
        param.put("actualCompletionAmount", actualCompletionAmount);
        System.out.println("작업완료등록_ServiceFacadeImpl");
        System.out.println(param);

        workOrderDAO.workOrderCompletion(param);

        return param;
    }

    /*****************************
     생산실적관리 Tab - 생산실적관리조회(JPA)
     *****************************/
//    @Override
//    public List<ProductionPerformance> getProductionPerformanceInfoList() {
//        System.out.println("여기 SF impl");
//        List<ProductionPerformance> ProductionPerformanceList = workOrderRepository.findAll();
//        return ProductionPerformanceList;
//    }
//
//생산실적관리 Tab - 생산실적관리조회(Spring)
//    @Override
//    public ArrayList<ProductionPerformanceInfoTO> getProductionPerformanceInfoList() {
//
//        return workOrderDAO.selectProductionPerformanceInfoList();
//    }
















//    @Override
//    public ArrayList<WorkOrderInfoTO> getWorkOrderInfoList() {
//        return workOrderAS.getWorkOrderInfoList();
//    }
//
//    @Override
//    public HashMap<String, Object> showWorkSiteSituation(String workSiteCourse, String workOrderNo,
//                                                         String itemClassIfication) {
//        return workOrderAS.showWorkSiteSituation(workSiteCourse, workOrderNo, itemClassIfication);
//    }
//
//    @Override
//    public void workCompletion(HashMap<String, ArrayList<WorkSiteSimulationTO>> workOrderInfo) {
//        workOrderAS.workCompletion(workOrderInfo);
//    }
}

