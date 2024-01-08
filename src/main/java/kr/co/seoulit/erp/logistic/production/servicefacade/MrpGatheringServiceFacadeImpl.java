package kr.co.seoulit.erp.logistic.production.servicefacade;


import kr.co.seoulit.erp.logistic.production.dao.MrpDAO;
import kr.co.seoulit.erp.logistic.production.dao.MrpGatheringDAO;
import kr.co.seoulit.erp.logistic.production.domain.MrpGathering;
import kr.co.seoulit.erp.logistic.production.domain.MrpGatheringDTO;
import kr.co.seoulit.erp.logistic.production.mapStruct.MrpGatheringMapper;
import kr.co.seoulit.erp.logistic.production.repository.MrpGatheringRepository;
import kr.co.seoulit.erp.logistic.production.to.MrpGatheringTO;
import kr.co.seoulit.erp.logistic.production.to.MrpTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

@Slf4j
@Service
public class MrpGatheringServiceFacadeImpl implements MrpGatheringServiceFacade{

    private final MrpDAO mrpDAO;
    private final MrpGatheringDAO mrpGatheringDAO;
    private final HashMap<String, Object> resultMap;
    private final MrpGatheringRepository mrpGatheringRepository;
    private final MrpGatheringMapper mrpGatheringMapper;

    public MrpGatheringServiceFacadeImpl(MrpDAO mrpDAO, MrpGatheringDAO mrpGatheringDAO, HashMap<String, Object> resultMap, MrpGatheringRepository mrpGatheringRepository, MrpGatheringMapper mrpGatheringMapper) {
        this.mrpDAO = mrpDAO;
        this.mrpGatheringDAO = mrpGatheringDAO;
        this.resultMap = resultMap;
        this.mrpGatheringRepository = mrpGatheringRepository;
        this.mrpGatheringMapper = mrpGatheringMapper;
    }

    /*****************************
     품목별 조달계획 디폴트 테이블 + ?
     *****************************/
    public HashMap<String, Object> searchMrpList(String mrpGatheringStatusCondition) {
        ArrayList<MrpTO> result = mrpDAO.selectMrpListAll(mrpGatheringStatusCondition);
        return putMrpResultMap(result);
    }
    public HashMap<String, Object> searchMrpList(String dateSearchCondition, String startDate, String endDate) {

        HashMap<String, String> param = new HashMap<>();
        param.put("dateSearchCondition", dateSearchCondition);
        param.put("startDate", startDate);
        param.put("endDate", endDate);

        ArrayList<MrpTO> result = mrpDAO.selectMrpList(param);
        return putMrpResultMap(result);
    }
    public HashMap<String, Object> searchMrpListAsMrpGatheringNo(String mrpGatheringNo) {
        ArrayList<MrpTO> result = mrpDAO.selectMrpListAsMrpGatheringNo(mrpGatheringNo);
        return putMrpResultMap(result);
    }
    /*****************************
     품목별 조달계획 디폴트 테이블 + ? 끝
     *****************************/



    /*****************************
       품목별 소요량 취합 실행 버튼
     *****************************/
    public HashMap<String, Object> getMrpGathering(String mrpNoArr) {

        String mrpNoList = mrpNoArr.toString().replace("[", "").replace("]", "");

        ArrayList<MrpGatheringTO> mrpGatheringList = mrpGatheringDAO.getMrpGathering(mrpNoList);


        try {
            resultMap.put("gridRowJson", mrpGatheringList);
            resultMap.put("errorCode", 1);
            resultMap.put("errorMsg", "�꽦怨�");

        } catch (Exception e2) {
            e2.printStackTrace();
            resultMap.put("errorCode", -2);
            resultMap.put("errorMsg", e2.getMessage());
        }
        return resultMap;
    }



    /*****************************
           취합 결과 등록 버튼
     1. MRP 테이블에 			        1) MRP_GATHERING_NO 업데이트             mrpDAO.changeMrpGatheringStatus(param)
                                    2) MRP_GATHERING_STATUS 업데이트         mrpDAO.changeMrpGatheringStatus(param)
     2. MRP_GATHERING 테이블에 		1) mrpGatheringTO 등록                  mrpGatheringDAO.insertMrpGathering(bean)
     3. CONTRACT_DETAIL 테이블에    	1) MRP_GATHERING_NO 업데이트             mrpGatheringDAO.updateMrpGatheringContract(parameter)
     *****************************/
    public HashMap<String, Object> registerMrpGathering(String mrpGatheringRegisterDate,
                                                        ArrayList<MrpGatheringTO> newMrpGatheringList,
                                                        HashMap<String, String> mrpNoAndItemCodeMap) {

        HashMap<String, Object> resultMap;
        HashMap<String, String> param = new HashMap<>();
        TreeSet<String> mrpGatheringNoSet = new TreeSet<>();

        HashMap<String, String> newMrpGatheringNo
                = getNewMrpGatheringNo(mrpGatheringRegisterDate, newMrpGatheringList);

        /**
         *  1) 등록할 MrpGatheringTO로 MrpGathering 테이블에 insert 후,
         *  2) {key: "INSERT_MAP", value: {key: itemCode, value: mrpGatheringNo}} 라는 resultMap 생성
         *  3) {key: "INSERT", value: ArrayList<mrpGatheringNo>} 라는 resultMap 생성
         **/
        resultMap = batchMrpGatheringListProcess(newMrpGatheringList);
        HashMap<String, String> mrpGatheringNoList = (HashMap<String, String>) resultMap.get("INSERT_MAP");

        for (String mrpGatheringNo : mrpGatheringNoList.values()) {
            mrpGatheringNoSet.add(mrpGatheringNo);
        }

        resultMap.put("firstMrpGatheringNo", mrpGatheringNoSet.pollFirst());
        resultMap.put("lastMrpGatheringNo", mrpGatheringNoSet.pollLast());

        /**
         * gson으로 "mrpNo" : "itemCode" 를 역직렬화 해서 {key: mrpNo, value: itemCode}한 것을
         * keySet 기준 반복문 돌려 itemCode를 얻고 그 itemCode로 새로운 mrpGatheringNo 추출
         * => itemCode 마다 mrpGatheringNo 부여받는다 ?
         * => MRP 테이블에 mrpNo 조건으로 mrpGatheringNo와 mrpGatheringStatus 업데이트
         */
        for (String mrpNo : mrpNoAndItemCodeMap.keySet()) {
            String itemCode = mrpNoAndItemCodeMap.get(mrpNo);
            String mrpGatheringNo = newMrpGatheringNo.get(itemCode);
            param.put("mrpNo", mrpNo);
            param.put("mrpGatheringNo", mrpGatheringNo);
            param.put("mrpGatheringStatus", "Y");
            mrpDAO.changeMrpGatheringStatus(param);
        }

        StringBuffer sb = new StringBuffer();

        for (String mrpGatheringNo : mrpGatheringNoList.values()) {
            sb.append(mrpGatheringNo);
            sb.append(",");
        }

        sb.delete(sb.toString().length() - 1, sb.toString().length());

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("mrpGatheringNoList", sb.toString());
        mrpGatheringDAO.updateMrpGatheringContract(parameter);


        resultMap.put("changeMrpGatheringStatus",
                mrpNoAndItemCodeMap.keySet().toString().replace("[", "").replace("]", ""));

        return resultMap;
    }


    /*****************************
            소요량 취합 조회
     *****************************/
    public List<MrpGathering> searchMrpGatheringList(String dateSearchCondition,
                                                     String startDate,
                                                     String endDate) {

        return mrpGatheringRepository.searchMrpGatheringList(dateSearchCondition, startDate, endDate);
    }


    /*****************************
     소요량 취합 조회 캘린더
     *****************************/
    @Override
    public List<MrpGatheringDTO> searchMrpGatheringCalendar(String month) {

        String transformedMonth = String.format("%02d", Integer.parseInt(month));

        List<MrpGathering> mrpGathering = mrpGatheringRepository.searchMrpGatheringCalendar(transformedMonth);

        List<MrpGatheringDTO> result = mrpGatheringMapper.toDtoList(mrpGathering);

        return result;
    }




    /****************************************************************/

    private HashMap<String, String> getNewMrpGatheringNo(String mrpGatheringRegisterDate, ArrayList<MrpGatheringTO> newMrpGatheringList) {
        int seq = mrpGatheringDAO.selectMrpGatheringSeqCount();
        int i;

        ArrayList<MrpGatheringTO> list = mrpGatheringDAO.selectMrpGatheringCount(mrpGatheringRegisterDate);

        TreeSet<Integer> intSet = new TreeSet<>();

        for (MrpGatheringTO mrpGathering : list) {
            String mrpGatheringNo = mrpGathering.getMrpGatheringNo();
            int no = Integer.parseInt(mrpGatheringNo.substring(mrpGatheringNo.length() - 2, mrpGatheringNo.length()));
            intSet.add(no);
        }

        if (intSet.isEmpty()) {
            i = 1;
        } else {
            i = intSet.pollLast() + 1;
        }

        HashMap<String, String> itemCodeAndMrpGatheringNoMap = new HashMap<>();

        StringBuffer newMrpGatheringNo = new StringBuffer();
        newMrpGatheringNo.append("MG");
        newMrpGatheringNo.append(mrpGatheringRegisterDate.replace("-", ""));
        newMrpGatheringNo.append("-");

        for (MrpGatheringTO bean : newMrpGatheringList) {
            bean.setMrpGatheringSeq(seq);
            bean.setMrpGatheringNo(newMrpGatheringNo.toString() + String.format("%03d", i++));
            bean.setStatus("INSERT");

            itemCodeAndMrpGatheringNoMap.put(bean.getItemCode(), bean.getMrpGatheringNo());
        }
        return itemCodeAndMrpGatheringNoMap;
    }


    public HashMap<String, Object> batchMrpGatheringListProcess(ArrayList<MrpGatheringTO> mrpGatheringTOList) {

        HashMap<String, Object> resultMap = new HashMap<>();
        HashMap<String, String> insertListMap = new HashMap<>();
        ArrayList<String> insertList = new ArrayList<>();
        ArrayList<String> updateList = new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();

        for (MrpGatheringTO bean : mrpGatheringTOList) {

            String status = bean.getStatus();

            switch (status) {
                case "INSERT":
                    mrpGatheringDAO.insertMrpGathering(bean);
                    insertList.add(bean.getMrpGatheringNo());
                    insertListMap.put(bean.getItemCode(), bean.getMrpGatheringNo());
                    break;
                case "UPDATE":
                    mrpGatheringDAO.updateMrpGathering(bean);
                    updateList.add(bean.getMrpGatheringNo());
                    break;
                case "DELETE":
                    mrpGatheringDAO.deleteMrpGathering(bean);
                    deleteList.add(bean.getMrpGatheringNo());
                    break;
            }
        }

        resultMap.put("INSERT_MAP", insertListMap);
        resultMap.put("INSERT", insertList);
        resultMap.put("UPDATE", updateList);
        resultMap.put("DELETE", deleteList);

        return resultMap;
    }

    public HashMap<String, Object> batchMrpListProcess(ArrayList<MrpTO> mrpTOList) {

        HashMap<String, Object> resultMap = new HashMap<>();

        ArrayList<String> insertList = new ArrayList<>();
        ArrayList<String> updateList = new ArrayList<>();
        ArrayList<String> deleteList = new ArrayList<>();

        for (MrpTO bean : mrpTOList) {
            String status = bean.getStatus();
            switch (status) {
                case "INSERT":
                    mrpDAO.insertMrp(bean);
                    insertList.add(bean.getMrpNo());
                    break;
                case "UPDATE":
                    mrpDAO.updateMrp(bean);
                    updateList.add(bean.getMrpNo());
                    break;
                case "DELETE":
                    mrpDAO.deleteMrp(bean);
                    deleteList.add(bean.getMrpNo());
                    break;
            }
        }

        resultMap.put("INSERT", insertList);
        resultMap.put("UPDATE", updateList);
        resultMap.put("DELETE", deleteList);

        return resultMap;
    }


    private HashMap<String, Object> putMrpResultMap(ArrayList<MrpTO> result) {
        try {
            resultMap.put("gridRowJson", result);
            resultMap.put("errorCode", 1);
            resultMap.put("errorMsg", "정상");
        } catch (Exception e2) {
            e2.printStackTrace();
            resultMap.put("errorCode", -2);
            resultMap.put("errorMsg", e2.getMessage());
        }
        return resultMap;
    }
}
