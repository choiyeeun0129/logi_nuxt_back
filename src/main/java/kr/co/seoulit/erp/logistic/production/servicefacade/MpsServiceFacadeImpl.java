package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.dao.MpsDAO;
import kr.co.seoulit.erp.logistic.production.domain.SalesPlan;
import kr.co.seoulit.erp.logistic.production.repository.MpsRepository;
import kr.co.seoulit.erp.logistic.production.repository.SalesPlanRepository;
import kr.co.seoulit.erp.logistic.production.to.ContractDetailInMpsAvailableTO;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.*;

@Slf4j
@Service
public class MpsServiceFacadeImpl implements MpsServiceFacade{

    private final MpsDAO mpsDAO;
    private final ModelMap modelMap;
    private final SalesPlanRepository salesPlanRepository;
    private final MpsRepository mpsRepository;

    @Autowired
    public MpsServiceFacadeImpl(MpsDAO mpsDAO, SalesPlanRepository salesPlanRepository, MpsRepository mpsRepository) {
        this.mpsDAO = mpsDAO;
        this.mpsRepository = mpsRepository;
        this.modelMap = new ModelMap();
        this.salesPlanRepository = salesPlanRepository;
    }

    /*****************************
          MPS 등록가능 수주 조회
     *****************************/
    @Override
    public Map<String, Object> getContractDetailListInMpsAvailable(String searchCondition, String startDate, String endDate) {


        ArrayList<ContractDetailInMpsAvailableTO> resultList
                = mpsDAO.selectContractDetailListInMpsAvailable(searchCondition, startDate, endDate);

        try {
            modelMap.put("gridRowJson", resultList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "실패!");
        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());
        }
        return modelMap;
    }
    /*****************************
         MPS 등록가능 수주 조회 끝
     *****************************/

    /*****************************
     MPS 등록가능 판매계획 조회(JPA)
     *****************************/
    @Transactional
    public List<SalesPlan> searchSalesPlan(String startDate,
                                           String endDate){

        List<SalesPlan> salesPlanList = salesPlanRepository.findByDate(startDate, endDate);
        return salesPlanList;
    }
    /*****************************
     MPS 등록가능 판매계획 조회(JPA) 끝
     *****************************/


    /*****************************
                MPS 등록
    (batchMpsListProcess - "INSERT")
    (processing status -> "Y")
     *****************************/
    @Override
    public HashMap<String, Object> convertContractDetailToMps(ContractDetailInMpsAvailableTO contractDetailInMpsAvailableTO) {

        contractDetailInMpsAvailableTO.setPlanClassification("수주");
        /**
         * contractDetailInMpsAvailableTO -> MpsTO 객체 변환 : 생성자 방식
         */
        MpsTO mpsTO = new MpsTO(contractDetailInMpsAvailableTO);
        mpsTO.setStatus("INSERT");

        HashMap<String, Object> resultMap = batchMpsListProcess(mpsTO);// batchMpsListProcess 메소드 호출

        return resultMap;
    }

    @Override
    @Transactional
    public void convertSalesPlanToMps(SalesPlan salesPlan) {
        salesPlan.setPlanClassification("판매계획");
        MpsTO mpsTO = new MpsTO(salesPlan);
        String newMpsNo = getNewMpsNo(mpsTO.getMpsPlanDate());
        mpsTO.setMpsNo(newMpsNo);
        mpsRepository.save(mpsTO);
        salesPlanRepository.changeMpsApplyStatus(salesPlan.getSalesPlanNo());
    }



    public HashMap<String, Object> batchMpsListProcess(MpsTO mpsTo) {

        HashMap<String, Object> resultMap = null;
        ArrayList<String> batchList = new ArrayList<>();

        switch (mpsTo.getStatus()) {

            case "INSERT":
                String newMpsNo = getNewMpsNo(mpsTo.getMpsPlanDate());

                // MPS TO 에 새로운 판매계획일련번호 세팅
                mpsTo.setMpsNo(newMpsNo);

                // MPS TO Insert
                mpsDAO.insertMps(mpsTo);

                // 생성된 새로운 MPS 번호를 ArrayList 에 추가
                batchList.add(newMpsNo);

                // MPS TO 의 수주상세번호가 존재하면, 수주상세 테이블에서 해당 번호의 MPS 적용상태를 'Y' 로 변경
                if (mpsTo.getContractDetailNo() != null) {
                    changeMpsStatusInContractDetail(mpsTo.getContractDetailNo(), "Y");
                }

                resultMap.put("INSERT", batchList);
                break;

            case "UPDATE":

                mpsDAO.updateMps(mpsTo);
                batchList.add(mpsTo.getMpsNo());
                resultMap.put("UPDATE", batchList);
                break;

            case "DELETE":

                mpsDAO.deleteMps(mpsTo);
                batchList.add(mpsTo.getMpsNo());
                resultMap.put("DELETE", batchList);
                break;
        }
        return resultMap;
    }
    public String getNewMpsNo(String mpsPlanDate) {

        StringBuffer newEstimateNo = null;

        List<MpsTO> mpsTOlist = mpsDAO.selectMpsCount(mpsPlanDate);
        TreeSet<Integer> intSet = new TreeSet<>();
        int i;
        for (MpsTO bean : mpsTOlist) {
            String mpsNo = bean.getMpsNo();

            int no = Integer.parseInt(mpsNo.substring(mpsNo.length() - 2, mpsNo.length()));
            intSet.add(no);
        }
        if (intSet.isEmpty()) {
            i = 1;
        } else {
            i = intSet.pollLast() + 1;
        }
        newEstimateNo = new StringBuffer();
        newEstimateNo.append("PS");
        newEstimateNo.append(mpsPlanDate.replace("-", ""));
        newEstimateNo.append(String.format("%02d", i));

        return newEstimateNo.toString();
    }
    public void changeMpsStatusInContractDetail(String contractDetailNo, String mpsStatus) {

        HashMap<String, String> param = new HashMap<>();
        param.put("contractDetailNo",contractDetailNo);
        param.put("mpsStatus", mpsStatus);

        mpsDAO.changeMpsStatusOfContractDetail(param);
    }
    /*****************************
            MPS 등록 끝
     *****************************/


    /*****************************
          차트용 MPS 테이블 조회
     *****************************/
    @Override
    public HashMap<String, Object> searchMpsList() {
        List<MpsTO> result = mpsDAO.searchMpsList();
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);
        return resultMap;
    }



}
